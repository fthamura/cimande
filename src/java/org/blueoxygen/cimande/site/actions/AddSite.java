/*******************************************************************************
 * Copyright (c) 2004 BlueOxygen Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BlueOxygen Software License v1.0
 * which accompanies this distribution, and is available at
 *
 * Contributors:
 *     BlueOxygen Team - initial API and implementation
 *******************************************************************************/

package org.blueoxygen.cimande.site.actions;

import java.sql.Timestamp;

import org.blueoxygen.cimande.LogInformation;
import org.blueoxygen.cimande.security.SessionCredentials;
import org.blueoxygen.cimande.security.SessionCredentialsAware;
import org.blueoxygen.cimande.site.Site;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * @author frans
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
@Validation
public class AddSite extends SiteForm implements SessionCredentialsAware {

	private SessionCredentials sessionCredentials;

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Name can't be empty."),
			@RequiredStringValidator(fieldName = "description", message = "Description can't be empty."), 
			@RequiredStringValidator(fieldName = "workspace_type", message= "Workspace Type can't be empty.") })
	public String execute() {
		//
		// if (getName().equalsIgnoreCase("")) {
		// addActionError("Name can't be empty.");
		// }

		if (hasErrors()) {
			return INPUT;
		} else {
			Site newSite = new Site();

			newSite.setName(getName());
			newSite.setTitle(getTitle());
			newSite.setDescription(getDescription());
			newSite.setUrl_branding(getUrl_branding());
			newSite.setSite_url(getSite_url());
			newSite.setAdmin_email(getAdmin_email());
			newSite.setNotify_flag(getNotify_flag());
			newSite.setNotify_email(getNotify_email());
			newSite.setNotify_from(getNotify_from());
			newSite.setNotify_message(getNotify_message());
			newSite.setWorkspace_type(getWorkspace_type());
			
			
			// newSite.setSite_headline(getSite_headline());

			LogInformation log = new LogInformation();

			if (sessionCredentials.getCurrentUser() != null) {
				log.setCreateBy(sessionCredentials.getCurrentUser().getId());
				log.setLastUpdateBy(sessionCredentials.getCurrentUser().getId());
			}

			log.setCreateDate(new Timestamp(System.currentTimeMillis()));
			log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));

			if (getActiveFlag() == -1) {
				// set activeFlag to inactive when not specified
				log.setActiveFlag(LogInformation.INACTIVE);
			} else {
				log.setActiveFlag(getActiveFlag());
			}

			newSite.setLogInformation(log);
			persistenceManager.save(newSite);

			return SUCCESS;
		}

	}

	public void setSessionCredentials(SessionCredentials sessionCredentials) {
		this.sessionCredentials = sessionCredentials;

	}

}