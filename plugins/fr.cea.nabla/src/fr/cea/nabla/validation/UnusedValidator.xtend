/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.nabla.validation

import com.google.inject.Inject
import fr.cea.nabla.nabla.ArgOrVarRef
import fr.cea.nabla.nabla.Connectivity
import fr.cea.nabla.nabla.ConnectivityCall
import fr.cea.nabla.nabla.ConnectivityVar
import fr.cea.nabla.nabla.Function
import fr.cea.nabla.nabla.FunctionCall
import fr.cea.nabla.nabla.ItemSet
import fr.cea.nabla.nabla.ItemSetRef
import fr.cea.nabla.nabla.ItemType
import fr.cea.nabla.nabla.NablaModule
import fr.cea.nabla.nabla.NablaPackage
import fr.cea.nabla.nabla.NablaRoot
import fr.cea.nabla.nabla.Reduction
import fr.cea.nabla.nabla.ReductionCall
import fr.cea.nabla.nabla.SpaceIterator
import fr.cea.nabla.nabla.SpaceIteratorRef
import fr.cea.nabla.nabla.TimeIterator
import fr.cea.nabla.nabla.TimeIteratorRef
import fr.cea.nabla.nabla.Var
import fr.cea.nabla.overloading.DeclarationProvider
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType

class UnusedValidator extends UniqueNameValidator
{
	@Inject extension DeclarationProvider

	public static val UNUSED = "Unused"
	static def getUnusedMsg(EClass objectClass, String objectName) { "Unused " + objectClass.name + ": " + objectName }

	@Check(CheckType.NORMAL)
	def checkUnusedTimeIterator(TimeIterator it)
	{
		val root = EcoreUtil2::getContainerOfType(it, NablaRoot)
		if (root !== null)
		{
			val elements = EcoreUtil2.getAllContentsOfType(root, TimeIteratorRef)
			val hasItRef = elements.exists[x | x.target === it]
			if (!hasItRef)
				warning(getUnusedMsg(NablaPackage.Literals.TIME_ITERATOR, name), NablaPackage.Literals.ARG_OR_VAR__NAME, UNUSED)
		}
	}

	@Check(CheckType.NORMAL)
	def checkUnusedVariable(Var it)
	{
		val root = EcoreUtil2::getContainerOfType(it, NablaRoot)
		if (root !== null)
		{
			val elements = EcoreUtil2.getAllContentsOfType(root, ArgOrVarRef)
			val referenced = elements.exists[x | x.target === it]
			if (!referenced)
				warning(getUnusedMsg(NablaPackage.Literals.VAR, name), NablaPackage.Literals::ARG_OR_VAR__NAME, UNUSED)
		}
	}

	@Check(CheckType.NORMAL)
	def checkUnusedConnectivity(Connectivity it)
	{
		val root = EcoreUtil2::getContainerOfType(it, NablaRoot)
		if (root !== null)
		{
			val cCalls = EcoreUtil2.getAllContentsOfType(root, ConnectivityCall)
			val cVars = EcoreUtil2.getAllContentsOfType(root, ConnectivityVar)
			val referenced = cCalls.exists[x | x.connectivity === it] || cVars.exists[x | x.supports.contains(it)]
			if (!referenced)
				warning(getUnusedMsg(NablaPackage.Literals.CONNECTIVITY, name), NablaPackage.Literals::CONNECTIVITY__NAME, UNUSED)
		}
	}

	@Check(CheckType.NORMAL)
	def checkUnusedItemType(ItemType it)
	{
		val root = EcoreUtil2::getContainerOfType(it, NablaRoot)
		if (root !== null)
		{
			val elements = EcoreUtil2.getAllContentsOfType(root, Connectivity)
			val referenced = elements.exists[x | x.inTypes.contains(it) || x.returnType === it]
			if (!referenced)
				warning(getUnusedMsg(NablaPackage.Literals.ITEM_TYPE, name), NablaPackage.Literals::ITEM_TYPE__NAME, UNUSED)
		}
	}

	@Check(CheckType.NORMAL)
	def checkUnusedSpaceIterator(SpaceIterator it)
	{
		val root = EcoreUtil2::getContainerOfType(it, NablaRoot)
		if (root !== null)
		{
			val elements = EcoreUtil2.getAllContentsOfType(root, SpaceIteratorRef)
			val referenced = elements.exists[x|x.target === it]
			if (!referenced)
				warning(getUnusedMsg(NablaPackage.Literals.SPACE_ITERATOR, name), NablaPackage.Literals::SPACE_ITERATOR__NAME, UNUSED)
		}
	}

	@Check(CheckType.NORMAL)
	def checkUnusedItemSet(ItemSet it)
	{
		val root = EcoreUtil2::getContainerOfType(it, NablaRoot)
		if (root !== null)
		{
			val elements = EcoreUtil2.getAllContentsOfType(root, ItemSetRef)
			val referenced = elements.exists[x|x.target === it]
			if (!referenced)
				warning(getUnusedMsg(NablaPackage.Literals.ITEM_SET, name), NablaPackage.Literals::ITEM_SET__NAME, UNUSED)
		}
	}

	@Check(CheckType.NORMAL)
	def checkUnusedFunction(Function it)
	{
		val m = EcoreUtil2::getContainerOfType(it, NablaModule)
		if (m !== null)
		{
			// If the root does not contains only functions & reductions, no unused warning.
			// It avoids warning on libraries: module with only functions/reductions.
			if (! (m.declarations.empty && m.jobs.empty && m.itemTypes.empty && m.connectivities.empty))
			{
				val allCalls = EcoreUtil2.getAllContentsOfType(m, FunctionCall)
				var referenced = false
				for (c : allCalls)
				{
					val matchingDeclaration = c.declaration
					if (matchingDeclaration !== null && matchingDeclaration.model === it)
						referenced = true
				}
				if (!referenced)
					warning(getUnusedMsg(NablaPackage.Literals.FUNCTION, name), NablaPackage.Literals::FUNCTION_OR_REDUCTION__NAME, UNUSED)
			}
		}
	}

	@Check(CheckType.NORMAL)
	def checkUnusedReduction(Reduction it)
	{
		val m = EcoreUtil2.getContainerOfType(it, NablaModule)
		// If the module does not contains only functions & reductions, no unused warning.
		// It avoids warning on libraries: module with only functions/reductions.
		if (! (m.declarations.empty && m.jobs.empty && m.itemTypes.empty && m.connectivities.empty))
		{
			val allMatchingDeclarations = EcoreUtil2.getAllContentsOfType(m, ReductionCall).map[declaration]
			val referenced = allMatchingDeclarations.exists[x | x !== null && x.model === it]
			if (!referenced)
				warning(getUnusedMsg(NablaPackage.Literals.REDUCTION, name), NablaPackage.Literals::FUNCTION_OR_REDUCTION__NAME, UNUSED)
		}
	}
}