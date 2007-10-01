package org.blueoxygen.cimande.gx2.db.table;

import org.blueoxygen.cimande.gx2.db.GXDBAccessorImpl;

public class ListTable extends TableForm {
	private String formId = "";
	
	public String execute(){
		accessor  = new GXDBAccessorImpl(manager);
		setTables(accessor.findAllActiveTable());
		return SUCCESS;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}
}