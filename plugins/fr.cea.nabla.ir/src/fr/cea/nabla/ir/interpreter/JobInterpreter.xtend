/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.nabla.ir.interpreter

import fr.cea.nabla.ir.ir.ConnectivityVariable
import fr.cea.nabla.ir.ir.InSituJob
import fr.cea.nabla.ir.ir.InstructionJob
import fr.cea.nabla.ir.ir.IrModule
import fr.cea.nabla.ir.ir.TimeLoop
import fr.cea.nabla.ir.ir.TimeLoopCopyJob
import fr.cea.nabla.ir.ir.TimeLoopJob
import fr.cea.nabla.javalib.mesh.PvdFileWriter2D
import java.util.HashMap

import static fr.cea.nabla.ir.interpreter.ExpressionInterpreter.*
import static fr.cea.nabla.ir.interpreter.InstructionInterpreter.*

import static extension fr.cea.nabla.ir.IrModuleExtensions.*
import static extension fr.cea.nabla.ir.interpreter.NablaValueSetter.*
import fr.cea.nabla.ir.ir.Job
import java.util.Arrays

class JobInterpreter
{
	val PvdFileWriter2D writer

	new (PvdFileWriter2D writer)
	{
		this.writer = writer
	}

	// Switch to more efficient dispatch (also clearer for profiling)
	def void interprete(Job it, Context context)
	{
		if (it instanceof TimeLoopJob) {
			interpreteTimeLoopJob(context)
		} else if (it instanceof InSituJob) {
			interpreteInSituJob(context)
		} else if (it instanceof InstructionJob) {
			interpreteInstructionJob(context)
		} else if (it instanceof TimeLoopCopyJob) {
			interpreteTimeLoopCopyJob(context)
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " +
				Arrays.<Object>asList(it, context).toString())
		}
	}

	def void interpreteInstructionJob(InstructionJob it, Context context)
	{
		context.logFinest("Interprete InstructionJob " + name + " @ " + at)
		val innerContext = new Context(context)
		interprete(instruction, innerContext)
	}

	def void interpreteInSituJob(InSituJob it, Context context)
	{
		context.logFinest("Interprete InSituJob " + name + " @ " + at)
		val irModule = eContainer as IrModule
		val iteration = context.getInt(nbCalls.name)
		val time = context.getReal(irModule.timeVariable.name)
		val period = context.getNumber(periodVariable.name)
		val lastDump = context.getNumber(lastDumpVariable.name)

		if (period >= lastDump)
		{
			val cellVariables = new HashMap<String, double[]>
			val nodeVariables = new HashMap<String, double[]>

			//TODO deal with linearAlgebra
			setItemVariables(context, irModule, "cell", cellVariables)
			setItemVariables(context, irModule, "node", nodeVariables)

			val coordVariable = irModule.getVariableByName(irModule.nodeCoordVariable.name)
			val coord = (context.getVariableValue(coordVariable) as NV2Real).data
			val quads = context.meshWrapper.quads
			writer.writeFile(iteration, time, coord, quads, cellVariables, nodeVariables)
			context.setVariableValue(lastDumpVariable, new NV0Real(period))
		}
	}

	def void interpreteTimeLoopJob(TimeLoopJob it, Context context)
	{
		context.logFinest("Interprete TimeLoopJob " + name + " @ " + at)
		val irModule = eContainer as IrModule
		val iterationVariable = timeLoop.iterationCounter
		var iteration = 0
		context.logVariables("Before timeLoop " + timeLoop.name)
		context.addVariableValue(iterationVariable, new NV0Int(iteration))
		var continueLoop = true
		do
		{
			iteration ++
			context.setVariableValue(iterationVariable, new NV0Int(iteration))
			context.logInfo(timeLoop.indentation + "[" + iteration + "] t: " +
				context.getReal(irModule.timeVariable.name) + " - deltat: " +
				context.getReal(irModule.deltatVariable.name)
			)
			for (j : innerJobs.filter[x | x.at > 0].sortBy[at])
				interprete(j, context)
			//context.logVariables("After iteration = " + iteration)

			continueLoop = (interprete(timeLoop.whileCondition, context) as NV0Bool).data

			if (continueLoop)
			{
				// Switch variables to prepare next iteration
				for (copy : copies)
				{
					val leftValue = context.getVariableValue(copy.destination)
					val rightValue = context.getVariableValue(copy.source)
					context.setVariableValue(copy.destination, rightValue)
					context.setVariableValue(copy.source, leftValue)
				}
			}
		}
		while (continueLoop)
		context.logVariables("After timeLoop " + iteration)
	}

	def void interpreteTimeLoopCopyJob(TimeLoopCopyJob it, Context context)
	{
		context.logFinest("Interprete TimeLoopCopyJob " + name + " @ " + at)

		for (copy : copies)
		{
			val sourceValue = context.getVariableValue(copy.source)
			val destinationValue = context.getVariableValue(copy.destination)
			destinationValue.setValue(#[], sourceValue)
		}
	}

	private def setItemVariables(InSituJob it, Context context, IrModule module, String itemName, HashMap<String, double[]> map)
	{
		for (v : dumpedVariables.filter(ConnectivityVariable).filter(v | v.type.connectivities.head.returnType.type.name == itemName))
		{
			val value = context.getVariableValue(module.getVariableByName(v.name))
			if (value instanceof NV1Real) map.put(v.persistenceName, value.data)
		}
	}

	private static def String getIndentation(TimeLoop it)
	{
		if (outerTimeLoop === null) ''
		else getIndentation(outerTimeLoop) + '\t'
	}
}
