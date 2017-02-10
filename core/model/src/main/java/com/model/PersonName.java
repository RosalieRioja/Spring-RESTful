package com.model;

import javax.persistence.*;

@Embeddable
public class PersonName {

	private String firstName;
	private String lastName;
	private String middleName;
	private String suffix;
	private String title;

	public PersonName() {}

	public PersonName(String fname_param, String lname_param, String mname_param, String suffix_param, String title_param) {
		
		this.setFirstName(fname_param);
		this.setLastName(lname_param);
		this.setMiddleName(mname_param);
		this.setSuffix(suffix_param);
		this.setTitle(title_param);
	}

	public void setFirstName(String fname_param) {
		this.firstName = fname_param;
	}

	public void setLastName(String lname_param) {
		this.lastName = lname_param;
	}

	public void setMiddleName(String mname_param) {
		this.middleName = mname_param;
	}

	public void setSuffix(String suffix_param) {
		this.suffix = suffix_param;
	}

	public void setTitle(String title_param) {
		this.title = title_param;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public String getTitle() {
		return this.title;
	}

}