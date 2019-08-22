/*******************************************************************************
 * Copyright (c) 2018 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.nabla.generator.ir

import com.google.inject.Inject
import com.google.inject.Singleton
import fr.cea.nabla.DeclarationProvider
import fr.cea.nabla.ir.Utils
import fr.cea.nabla.ir.ir.IrFactory
import fr.cea.nabla.nabla.ReductionCall
import fr.cea.nabla.typing.ArrayType
import fr.cea.nabla.typing.DefinedType
import fr.cea.nabla.typing.UndefinedType
import fr.cea.nabla.typing.AbstractType

/**
 * Attention : cette classe doit être un singleton car elle utilise des méthodes create.
 * Si elle n'est pas singleton, plusieurs instances d'un même objet seront créées (voir la documentation Xtext).
 */
@Singleton
class ReductionCallExtensions 
{
	@Inject extension DeclarationProvider
	@Inject extension Nabla2IrUtils
	@Inject extension IrExpressionFactory
	
	def create IrFactory::eINSTANCE.createSimpleVariable toIrLocalVariable(ReductionCall rc)
	{
		name = rc.reduction.name + Utils::hashString(rc)
		val d = rc.declaration
		type = d.returnType.toIrBaseType
		
		val seedExpression = d.model.seed.toIrExpression
		if (type.sizes.empty)
			defaultValue = seedExpression
		else
			defaultValue = IrFactory::eINSTANCE.createBaseTypeConstant =>
			[
				type = d.returnType.toIrExpressionType
				value = seedExpression
			]	
	}

	// no connectivies on the ExpressionType for the Reduction
	private def toIrBaseType(AbstractType t)
	{
		switch t
		{
			UndefinedType: null
			ArrayType: IrFactory::eINSTANCE.createBaseType =>
			[
				root = t.root.toIrPrimitiveType
				sizes.addAll(t.sizes)
			]
			DefinedType: IrFactory::eINSTANCE.createBaseType =>
			[
				root = t.root.toIrPrimitiveType
			]
		}
	}
}