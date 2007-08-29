/*******************************************************************************
 * Copyright (c) 2004 BlueOxygen Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BlueOxygen Software License v1.0
 * which accompanies this distribution, and is available at
 *
 * Contributors:
 *     BlueOxygen Team - initial API and implementation
 *******************************************************************************/

package org.blueoxygen.backoffice;

public class Descriptor {
	String 	keyId, description;

	public Descriptor(String id, String value) { 
		keyId = id;
		description=value;
	
	}
	 
	public String getId() {
		return keyId;
	}
	
	public String getValue() {
		return description;
	}
	
	
}

			