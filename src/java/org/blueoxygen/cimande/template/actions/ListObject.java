/**
 * 
 */
package org.blueoxygen.cimande.template.actions;

import java.util.ArrayList;
import java.util.List;

import org.blueoxygen.cimande.persistence.PersistenceAware;
import org.blueoxygen.cimande.persistence.PersistenceManager;
import org.blueoxygen.cimande.template.TemplateObject;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Ikromy
 *
 */
public class ListObject extends ActionSupport implements PersistenceAware{
	private List obj = new ArrayList();
	private TemplateObject object;
	private PersistenceManager pm;
	
	public String execute(){
		obj = pm.findAllSorted(TemplateObject.class, "description");
		return SUCCESS;
	}

	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
			this.pm = persistenceManager;
	}
	
	/**
	 * @return Returns the objects.
	 */
	public TemplateObject getObject() {
		return object;
	}
	/**
	 * @param objCollection The objects to set.
	 */
	public void setObject(TemplateObject object) {
		this.object = object;
	}
	/**
	 * @return Returns the obj.
	 */
	public List getObj() {
		return obj;
	}
	/**
	 * @param obj The obj to set.
	 */
	public void setobj(List obj) {
		this.obj = obj;
	}

}
