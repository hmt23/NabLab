/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.nabla.ir

import fr.cea.nabla.ir.ir.ArgOrVarRef
import fr.cea.nabla.ir.ir.BaseType
import fr.cea.nabla.ir.ir.BaseTypeConstant
import fr.cea.nabla.ir.ir.BinaryExpression
import fr.cea.nabla.ir.ir.BoolConstant
import fr.cea.nabla.ir.ir.ConnectivityType
import fr.cea.nabla.ir.ir.ContractedIf
import fr.cea.nabla.ir.ir.FunctionCall
import fr.cea.nabla.ir.ir.IntConstant
import fr.cea.nabla.ir.ir.IrType
import fr.cea.nabla.ir.ir.LinearAlgebraType
import fr.cea.nabla.ir.ir.MaxConstant
import fr.cea.nabla.ir.ir.MinConstant
import fr.cea.nabla.ir.ir.Parenthesis
import fr.cea.nabla.ir.ir.PrimitiveType
import fr.cea.nabla.ir.ir.RealConstant
import fr.cea.nabla.ir.ir.UnaryExpression
import fr.cea.nabla.ir.ir.VectorConstant

import static extension fr.cea.nabla.ir.Utils.*

class IrTypeExtensions
{
	static def String getLabel(IrType it)
	{
		switch it
		{
			case null: null
			BaseType case sizes.empty: primitive.literal
			BaseType case sizes.forall[x | x instanceof IntConstant]: primitive.literal + sizes.map[x | (x as IntConstant).value.utfExponent].join('\u02E3')
			BaseType: primitive.literal + '[' + sizes.map[expressionLabel].join(',') + ']'
			ConnectivityType: base.label + '{' + connectivities.map[name].join(',') + '}'
			LinearAlgebraType case sizes.size == 1: 'Vector[' + sizes.head.expressionLabel + ']'
			LinearAlgebraType case sizes.size == 2: 'Matrix[' + sizes.map[expressionLabel].join(',') + ']'
			default: null
		}
	}

	static def int getDimension(IrType it)
	{
		switch it
		{
			BaseType: sizes.size
			ConnectivityType: base.sizes.size + connectivities.size
			LinearAlgebraType: sizes.size
			default: 0
		}
	}

	static def int getSizesSize(IrType it)
	{
		switch it
		{
			BaseType: sizes.size
			ConnectivityType: base.sizes.size
			LinearAlgebraType: sizes.size
			default: 0
		}
	}

	static def isScalar(IrType t)
	{
		(t instanceof BaseType) && (t as BaseType).sizes.empty
	}

	static def getPrimitive(IrType t)
	{
		switch t
		{
			ConnectivityType: t.base.primitive
			BaseType: t.primitive
			LinearAlgebraType: PrimitiveType.REAL
		}
	}

	private static def dispatch String getExpressionLabel(ContractedIf it) { condition?.expressionLabel + ' ? ' + thenExpression?.expressionLabel + ' : ' + elseExpression?.expressionLabel }
	private static def dispatch String getExpressionLabel(BinaryExpression it) { left?.expressionLabel + ' ' + operator + ' ' + right?.expressionLabel }
	private static def dispatch String getExpressionLabel(UnaryExpression it) { operator + expression?.expressionLabel }
	private static def dispatch String getExpressionLabel(Parenthesis it) { '(' + expression?.expressionLabel + ')' }
	private static def dispatch String getExpressionLabel(IntConstant it) { value.toString }
	private static def dispatch String getExpressionLabel(RealConstant it) { value.toString }
	private static def dispatch String getExpressionLabel(BoolConstant it) { value.toString }
	private static def dispatch String getExpressionLabel(MinConstant it) { '-\u221E' }
	private static def dispatch String getExpressionLabel(MaxConstant it) { '-\u221E' }
	private static def dispatch String getExpressionLabel(BaseTypeConstant it) { type?.label + '(' + value?.expressionLabel + ')' }
	private static def dispatch String getExpressionLabel(VectorConstant it) { '[' + values.map[expressionLabel].join(',') + ']' }
	private static def dispatch String getExpressionLabel(FunctionCall it) { function.name + '(' + args.map[expressionLabel].join(',') + ')' }
	private static def dispatch String getExpressionLabel(ArgOrVarRef it)
	{
		var label = target.name
		if (!iterators.empty) label += '{' + iterators.map[x | x?.name].join(',') + '}'
		if (!indices.empty) label += '[' + indices.map[x | x?.expressionLabel].join(',') + ']'
		return label
	}
}