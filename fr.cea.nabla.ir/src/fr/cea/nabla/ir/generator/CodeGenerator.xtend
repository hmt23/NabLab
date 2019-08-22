/*******************************************************************************
 * Copyright (c) 2018 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.nabla.ir.generator

import fr.cea.nabla.ir.ir.IrModule
import org.eclipse.xtend.lib.annotations.Accessors

abstract class CodeGenerator 
{
	@Accessors val String name
	@Accessors val String fileExtension

	new(String name, String fileExtension)
	{
		this.name = name
		this.fileExtension = fileExtension
	}
	
	abstract def CharSequence getFileContent(IrModule it)	
}