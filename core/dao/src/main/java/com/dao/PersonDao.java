package com.dao;

import com.model.*;

import java.util.*;

public interface PersonDao {

	public boolean addPerson(Person person);
	public Person getPerson(int personID);
	public boolean updatePerson(Person updatedPerson);
	public boolean deletePerson(int personID);
	public List<Person> listPersons();
	public List<Person> listPersonsCriteria(String sort);
	public List<Person> listPersonsQuery(String sort, String column);

	//================================================================

	//public Roles getRole(int roleID);
	//public List<Roles> listRoles();

}