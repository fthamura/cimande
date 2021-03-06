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

import org.blueoxygen.cimande.CimandeAction;
import org.blueoxygen.cimande.LogInformation;
import org.blueoxygen.cimande.persistence.PersistenceAware;
import org.blueoxygen.cimande.persistence.PersistenceManager;
import org.blueoxygen.cimande.security.User;


import com.opensymphony.xwork2.ActionSupport;

/**
 */
public class SiteForm extends CimandeAction implements PersistenceAware
{
	protected PersistenceManager persistenceManager;
	protected LogInformation logInfo;
	private User user = new User();
	
	private String id="";
	private String name="";
	private String description="";
	private String theme_id="";
 	private String title="";
 	private String url_branding="";
 	private String site_url="";
 	private String admin_email="";
 	private int notify_flag=-1;
 	private int activeFlag=-1;
 	private String notify_email="";
 	private String notify_from="";
 	private String notify_message="";
 	private String site_headline="";
 	private String workspace_type="";
 	private String workType="";
 	
 	public String execute(){
 		user = (User) persistenceManager.getById(User.class, getCurrentUser().getId());
		if(user.getWorkspace_type().equalsIgnoreCase("flat")){
			workType = "flat";
		}else{
			workType = "";
		}
 		return SUCCESS;
 	}
 	
	 
	public String getWorkspace_type() {
		return workspace_type;
	}
	public void setWorkspace_type(String workspace_type) {
		this.workspace_type = workspace_type;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int active_flag) {
		this.activeFlag = active_flag;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNotify_flag() {
		return notify_flag;
	}
	public void setNotify_flag(int notify_flag) {
		this.notify_flag = notify_flag;
	}
	public String getNotify_email() {
		return notify_email;
	}
	public void setNotify_email(String notify_email) {
		this.notify_email = notify_email;
	}
	public String getNotify_from() {
		return notify_from;
	}
	public void setNotify_from(String notify_from) {
		this.notify_from = notify_from;
	}
	public String getNotify_message() {
		return notify_message;
	}
	public void setNotify_message(String notify_message) {
		this.notify_message = notify_message;
	}
	public PersistenceManager getPersistenceManager() {
		return persistenceManager;
	}
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}
	public String getSite_headline() {
		return site_headline;
	}
	public void setSite_headline(String site_headline) {
		this.site_headline = site_headline;
	}
	public String getSite_url() {
		return site_url;
	}
	public void setSite_url(String site_url) {
		this.site_url = site_url;
	}
	public String getTheme_id() {
		return theme_id;
	}
	public void setTheme_id(String theme_id) {
		this.theme_id = theme_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl_branding() {
		return url_branding;
	}
	public void setUrl_branding(String url_branding) {
		this.url_branding = url_branding;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	
	
}
