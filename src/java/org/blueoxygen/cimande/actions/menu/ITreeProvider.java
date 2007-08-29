/*******************************************************************************
 * Copyright (c) 2004 BlueOxygen Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BlueOxygen Software License v1.0
 * which accompanies this distribution, and is available at
 *
 * Contributors:
 *     BlueOxygen Team - initial API and implementation
 *******************************************************************************/
package org.blueoxygen.cimande.actions.menu;

/**
 * @author ginanjar
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface ITreeProvider {
	Object[] getChildren(Object element);
	Object[] getElements();
	boolean hasChildren(Object element);
	Object getParent();
	String getText();
	
}
