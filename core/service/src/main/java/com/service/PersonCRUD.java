package com.service;

import com.model.*;
import com.dao.*;
import com.util.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//impl
@Service
public class PersonCRUD implements CRUD<PersonDTO> {

	@Autowired
	private PersonDao personDao;
	@Autowired
	private ConvertModelDTO convertModelDTO;

	public PersonCRUD() {
		//personDao = new PersonDao();
		//convertModelDTO = new ConvertModelDTO();
	}

	public void create(PersonDTO person) {
		if(personDao.addPerson(convertModelDTO.setDTOToModel(person))) { 
			System.out.println("Record has been successfully added!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to add person.");
		}
	}

	public List<PersonDTO> read(int sort) {
		List<Person> lstPerson = null;

		switch(sort) {
			case SortValue.SORT_GWA_ASC :
				lstPerson = personDao.listPersonsQuery(SortValue.SORT_ASC, "GWA");
				break;
			case SortValue.SORT_GWA_DESC :
				lstPerson = personDao.listPersonsQuery(SortValue.SORT_DESC, "GWA");
				break;
			case SortValue.SORT_DATEHIRED_ASC :
				lstPerson = personDao.listPersonsQuery(SortValue.SORT_ASC, "dateHired");
				break;
			case SortValue.SORT_DATEHIRED_DESC :
				lstPerson = personDao.listPersonsQuery(SortValue.SORT_DESC, "dateHired");
				break;
			case SortValue.SORT_LASTNAME_ASC :
				lstPerson = personDao.listPersonsQuery(SortValue.SORT_ASC, "lastName");
				break;
			case SortValue.SORT_LASTNAME_DESC :
				lstPerson = personDao.listPersonsQuery(SortValue.SORT_DESC, "lastName");
				break;
			case SortValue.SORT_NONE :
				lstPerson = personDao.listPersons();
		}

		if(lstPerson == null) {
			System.out.println("Nothing to show.");
		}

		return convertModelDTO.setListModelToDTO(lstPerson);
	}

	public void update(PersonDTO person) {
		if(personDao.updatePerson(convertModelDTO.setDTOToModel(person))) {
			System.out.println("Record has been successfully updated!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to update person record.");
		}
	}

	public void delete(int id_param) {
		if(personDao.deletePerson(id_param)) {
			System.out.println("Record has been successfully deleted!\n");
		}
		else {
			System.out.println("Unsuccessful attempt to delete person record.");
		}
	}

	public PersonDTO get(int id_param) {
		return convertModelDTO.setModelToDTO(personDao.getPerson(id_param));
	}

}