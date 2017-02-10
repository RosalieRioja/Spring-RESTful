package com.service;

import com.model.*;

import java.util.*;

public interface ConvertModelDTO {

	public List<PersonDTO> setListModelToDTO(List<Person> personModel);
	public PersonDTO setModelToDTO(Person person);
	public Person setDTOToModel(PersonDTO personDTO);
	public Set<ContactsDTO> setContactListModelToDTO(Set<Contacts> contactsModel);
	public Set<Contacts> setContactListDTOToModel(Set<ContactsDTO> contactsDTO);
}