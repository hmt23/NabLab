/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.nabla

import fr.cea.nabla.nabla.ConnectivityCall
import fr.cea.nabla.nabla.ItemSetRef
import fr.cea.nabla.nabla.ItemType
import fr.cea.nabla.nabla.SpaceIterator

class SpaceIteratorExtensions
{
	def ItemType getType(SpaceIterator it)
	{
		container.connectivity.returnType
	}

	def boolean isMultiple(SpaceIterator it)
	{
		container.connectivity.multiple
	}

	private def dispatch getConnectivity(ConnectivityCall it) { connectivity }
	private def dispatch getConnectivity(ItemSetRef it) { target.value.connectivity }
}