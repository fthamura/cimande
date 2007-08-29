/*******************************************************************************
 * Copyright (c) 2004 BlueOxygen Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BlueOxygen Software License v1.0
 * which accompanies this distribution, and is available at
 *
 * Contributors:
 *     BlueOxygen Team - initial API and implementation
 *******************************************************************************/
package org.blueoxygen.cimande.collection;
/**
 * @version 	1.0
 * @author
 */
public class CollectionData implements Comparable{


    private String sName = null;
    private String sDescription = null;
    private String sId = null;
    private String sSiteId = null;
    private String sSkinId = null;
    private String sSkinName = null;
    private String sStatus = null;
    private String sActiveFlag = null;
    
	public CollectionData () throws Exception {
			super();		
		}
    
    public CollectionData(String sName,String sDescription,String sId,String sSiteId,String sSkinId,String sSkinName,String sStatus,String sActiveFlag) {
        
        this.sName = sName;
        this.sDescription = sDescription;
        this.sId = sId;
        this.sSiteId = sSiteId;
        this.sSkinId = sSkinId;
        this.sSkinName = sSkinName;
        this.sStatus = sStatus;
        this.sActiveFlag = sActiveFlag;
        
    }
    public String getName() {
       return this.sName;
    }

    public String getDescription() {
       return this.sDescription;
    }
    
    public String getId() {
       return this.sId;
    }
    public String getSiteId() {
       return this.sSiteId;
    }

    public String getSkinId() {
       return this.sSkinId;
    }
    
    public String getSkinName() {
       return this.sSkinName;
    }
    
    public String getStatus() {
       return this.sStatus;
    }
    public String getActiveFlag() {
       return this.sActiveFlag;
    }

  public int compareTo(Object o) {
	CollectionData n = (CollectionData)o;
	int lastCmp = sId.compareTo(n.sId);
		return (lastCmp);
  }		
}