package com.model;

import java.util.*;
import javax.persistence.*;

import com.util.*;

@Entity
@Table(name = "tblPerson")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Embedded
	private PersonName name;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "GWA")
	private float GWA;

	@Temporal(TemporalType.DATE)
	@Column (name = "dateHired")
	private Date dateHired;

	@Column(name = "currentlyEmployed")
	private boolean currentlyEmployed;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private PersonGender gender;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private PersonAddress address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "personId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Contacts> contacts;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "tblPerson_Role", joinColumns = @JoinColumn(name = "personId"), inverseJoinColumns = @JoinColumn(name = "roleId", updatable = false))
	private Set<Roles> roles;

	public Person() {}

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

	public Set<Contacts> getContacts() {
		return this.contacts;
	}
	
	public void setContacts(Set<Contacts> contacts_param) {
		this.contacts = contacts_param;
	}

	public Set<Roles> getRoles() {
		return this.roles;
	}
	
	public void setRoles(Set<Roles> roles_param) {
		this.roles = roles_param;
	}

}