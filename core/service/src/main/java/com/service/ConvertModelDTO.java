package com.service;

import com.model.*;

import java.util.*;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertModelDTO {

	public ConvertModelDTO() {}

	public List<PersonDTO> setListModelToDTO(List<Person> personModel) {
		List personDTO =  new ArrayList<PersonDTO>();

        for(Person person : personModel) {
        	personDTO.add(setModelToDTO(person));
    	}

    	return personDTO;
	}

	public PersonDTO setModelToDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();

		personDTO.setId(person.getId());
		personDTO.setName(person.getName());
		personDTO.setGWA(person.getGWA());
		personDTO.setBirthday(person.getBirthday());
		personDTO.setDateHired(person.getDateHired());
		personDTO.setCurrentlyEmployed(person.getCurrentlyEmployed());
		personDTO.setGender(person.getGender());
		personDTO.setAddress(person.getAddress());
		personDTO.setContacts(setContactListModelToDTO(person.getContacts()));
		personDTO.setRoles(person.getRoles());

		return personDTO;
	}

	public Person setDTOToModel(PersonDTO personDTO) {
		Person person = new Person();

		person.setId(personDTO.getId());
		person.setName(personDTO.getName());
		person.setGWA(personDTO.getGWA());
		person.setBirthday(personDTO.getBirthday());
		person.setDateHired(personDTO.getDateHired());
		person.setCurrentlyEmployed(personDTO.getCurrentlyEmployed());
		person.setGender(personDTO.getGender());
		person.setAddress(personDTO.getAddress());
		person.setContacts(setContactListDTOToModel(personDTO.getContacts()));
		person.setRoles(personDTO.getRoles());

		return person;
	}

	private Set<ContactsDTO> setContactListModelToDTO(Set<Contacts> contactsModel) {
		Set contactsDTO =  new HashSet<ContactsDTO>();

		if(contactsModel != null) {
	        for(Contacts contact : contactsModel) {
	        	ContactsDTO newContactDTO = new ContactsDTO();
	        	newContactDTO.setId(contact.getId());
	        	newContactDTO.setType(contact.getType());
	        	newContactDTO.setValue(contact.getValue());
	        	newContactDTO.setPerson(contact.getPerson());

	        	contactsDTO.add(newContactDTO);
	    	}
	    }

    	return contactsDTO;
	}

	private Set<Contacts> setContactListDTOToModel(Set<ContactsDTO> contactsDTO) {
		Set contactsModel =  new HashSet<Contacts>();

		if(contactsDTO != null) {
        	for(ContactsDTO contact : contactsDTO) {
	        	Contacts newContactModel = new Contacts();
	        	newContactModel.setId(contact.getId());
	        	newContactModel.setType(contact.getType());
	        	newContactModel.setValue(contact.getValue());
	        	newContactModel.setPerson(contact.getPerson());

	        	contactsModel.add(newContactModel);
	    	}
		}

    	return contactsModel;
	}

}