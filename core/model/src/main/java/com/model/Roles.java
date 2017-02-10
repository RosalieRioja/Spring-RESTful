package com.model;

import java.util.*;
import javax.persistence.*;

//import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tblRole")
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)//, region = "Roles")
public class Roles {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "value")
	private String value;

	@ManyToMany
	public Set<Person> person;
	
	public Roles() {}
	
	public int getId() {
		return this.id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue( String value_param ) {
		this.value = value_param;
	}

	public Set<Person> getPerson() {
		return this.person;
	}

	public void setPerson(Set<Person> person_param) {
		this.person = person_param;
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!this.getClass().equals(obj.getClass())) return false;
		
		Roles obj2 = (Roles)obj;
		
		if((this.value.equals(obj2.getValue())))
		{
			return true;
		}
		
		return false;
	}
	
	public int hashCode() {
		return this.value.hashCode();
	}
	
}