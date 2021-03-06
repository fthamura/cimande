/*******************************************************************************
 * Copyright (c) 2004 BlueOxygen Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BlueOxygen Software License v1.0
 * which accompanies this distribution, and is available at
 *
 * Contributors:
 *     BlueOxygen Team - initial API and implementation
 *******************************************************************************/

package org.blueoxygen.cimande.security.usermanager.actions;

import org.blueoxygen.cimande.role.UserRole;
import org.blueoxygen.cimande.security.usermanager.actions.ViewRole;
/**
 * @author Abdul Rizal
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class DeleteRole extends UserRoleForm {

	public String execute() {

		String result = super.execute();
		if(getUserRole().getId() != null && !"".equalsIgnoreCase(getUserRole().getId())){
			setUserRole((UserRole) getManager().getById(UserRole.class, getUserRole().getId()));
		}
		if (result.equalsIgnoreCase(SUCCESS)) {

			getManager().remove(getUserRole());
			return SUCCESS;
		} else {
			addActionError("Cannot find such Descriptor");
			return ERROR;
		}
	}
}