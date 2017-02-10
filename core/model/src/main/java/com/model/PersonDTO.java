package com.model;

import java.util.*;

import com.util.*;

public class PersonDTO {

	private int id;
	private PersonName name;
	private Date birthday;
	private float GWA;
	private Date dateHired;
	private boolean currentlyEmployed;
	private PersonGender gender;
	private PersonAddress address;
	private Set<ContactsDTO> contacts;
	private Set<Roles> roles;

	public PersonDTO() {}

	public void setId(int id_param) {
		this.id = id_param;
	}

	public void setName(PersonName name_param) {
		this.name = name_param;
	}

	public void setBirthday(Date bday_param) {
		this.birthday = bday_param;
	}

	public void setGWA(float gwa_param) {
		this.GWA = gwa_param;
	}

	public void setDateHired(Date datehired_param) {
		this.dateHired = datehired_param;
	}

	public void setCurrentlyEmployed(boolean currEmployed_param) {
		this.currentlyEmployed = currEmployed_param;
	}

	public void setGender(PersonGender gender_param) {
		this.gender = gender_param;
	}

	public void setAddress(PersonAddress address_param) {
		this.address = address_param;
	}

	public int getId() {
		return this.id;
	}

	public PersonName getName() {
		return this.name;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public float getGWA() {
		return this.GWA;
	}

	public Date getDateHired() {
		return this.dateHired;
	}

	public boolean getCurrentlyEmployed() {
		return this.currentlyEmployed;
	}

	public PersonGender getGender() {
		return this.gender;
	}

	public PersonAddress getAddress() {
		return this.address;
	}

	public Set<ContactsDTO> getContacts() {
		return this.contacts;
	}
	
	public void setContacts(Set<ContactsDTO> contacts_param) {
		this.contacts = contacts_param;
	}

	public Set<Roles> getRoles() {
		return this.roles;
	}
	
	public void setRoles(Set<Roles> roles_param) {
		this.roles = roles_param;
	}

}