/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.nabla.ir.generator.java

import fr.cea.nabla.ir.ir.ArgOrVarRef
import fr.cea.nabla.ir.ir.BaseType
import fr.cea.nabla.ir.ir.Function
import fr.cea.nabla.ir.ir.InternFunction
import fr.cea.nabla.ir.ir.IrType
import fr.cea.nabla.ir.ir.LinearAlgebraType
import fr.cea.nabla.ir.ir.Variable

import static extension fr.cea.nabla.ir.generator.java.InstructionContentProvider.*
import static extension fr.cea.nabla.ir.generator.java.IrTypeExtensions.*

class FunctionContentProvider
{
	static def getContent(InternFunction it)
	'''
		private «headerContent»
		{
			«FOR dimVar : variables»
			final int «dimVar.name» = «getSizeOf(dimVar)»;
			«ENDFOR»
			«body.innerContent»
		}
	'''

	static def getHeaderContent(Function it)
	'''«returnType.javaType» «name.toFirstLower»(«FOR a : inArgs SEPARATOR ', '»«a.type.javaType» «a.name»«ENDFOR»)'''

	private static def getSizeOf(Function it, Variable v)
	{
		for (a : inArgs)
		{
			var skippedDimensions = ""
			for (expr : a.type.sizes)
			{
				if (expr instanceof ArgOrVarRef && (expr as ArgOrVarRef).target === v)
					return a.name + skippedDimensions + '.length'
				skippedDimensions += "[0]"
			}
		}
		throw new RuntimeException("No arg corresponding to dimension symbol " + v.name)
	}

	private static def getSizes(IrType it)
	{
		switch it
		{
			BaseType: sizes
			LinearAlgebraType: sizes
			default: throw new RuntimeException("Unsuported argument")
		}
	}
}