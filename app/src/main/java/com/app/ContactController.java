package com.app;

import com.model.*;
import com.service.*;
import com.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.*;
//import org.springframework.web.servlet.mvc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.text.*;
import java.text.DateFormat;

@Controller
public class ContactController {

    private CRUD<PersonDTO> personCRUD;

    @Autowired
    public ContactController(CRUD<PersonDTO> personCRUDParam) {
        personCRUD = personCRUDParam;
    }

    @RequestMapping("/Contact/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String personId = request.getParameter("personId");

        ModelAndView model = new ModelAndView("ListContact");
        if(personId == null) {
            personId = String.valueOf(request.getSession().getAttribute("personId"));
        }
        PersonDTO lstContact = personCRUD.get(Integer.parseInt(personId));
        model.addObject("person", lstContact);

        return model;
    }

    @RequestMapping("/Contact/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("AddContact");
        model.addObject("personId", request.getParameter("personId"));

        return model;
    }

    @RequestMapping("/Contact/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("AddContact");

        int contactId;
        ContactsDTO contact;
        PersonDTO editPerson = personCRUD.get(Integer.parseInt(request.getParameter("personId")));
        contact = new ContactsDTO();
        contactId = Integer.parseInt(request.getParameter("editId"));
        for(ContactsDTO getContact : editPerson.getContacts()) {
            if(getContact.getId() == contactId) {
                contact = getContact;
                break;
            }
        }
        model.addObject("personId", editPerson.getId());
        model.addObject("contact", contact);

        return model;
    }

    @RequestMapping("/Contact/delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("redirect:/Contact/list");

        int contactId;
        ContactsDTO contact;
        PersonDTO personDelete = personCRUD.get(Integer.parseInt(request.getParameter("personId")));
        contactId = Integer.parseInt(request.getParameter("deleteId"));
        for(ContactsDTO contactDelete : personDelete.getContacts()) {
            if(contactDelete.getId() == contactId) {
                personDelete.getContacts().remove(contactDelete);
                break;
            }
        }
        personCRUD.update(personDelete);

        request.getSession().setAttribute("personId", request.getParameter("personId"));

        return model;
    }

    @RequestMapping("/Contact/submit")
    public ModelAndView submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("redirect:/Contact/list");

        int contactId;
        ContactsDTO contact;
        PersonDTO person = new PersonDTO();
        Set<ContactsDTO> personContacts;
        contact = new ContactsDTO();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        try{
            person = personCRUD.get(Integer.parseInt(request.getParameter("personId")));
            personContacts = person.getContacts();
            
            if(!request.getParameter("contactId").equals("") && request.getParameter("contactId") != null) {
                contactId = Integer.parseInt(request.getParameter("contactId"));

                System.out.println("edit contact " + contactId);

                for(ContactsDTO getContact : personContacts) {
                    if(getContact.getId() == contactId) {
                        contact = getContact;
                        break;
                    }
                }
            }//edit
            else {
                System.out.println("add contact");

                if(personContacts == null) {
                    personContacts = new HashSet<ContactsDTO>();
                    person.setContacts(personContacts);
                    personContacts = person.getContacts();
                }
                contact = new ContactsDTO();
            }//add new

            switch(request.getParameter("type")) {
                case "LANDLINE" :
                    contact.setType(ContactType.LANDLINE);
                    break;
                case "MOBILE" :
                    contact.setType(ContactType.MOBILE);
                    break;
                case "EMAIL" :
                    contact.setType(ContactType.EMAIL);
                    break;
            }

            contact.setValue(request.getParameter("value"));

            personContacts.add(contact);
            personCRUD.update(person);
        }
        catch(IllegalArgumentException | NullPointerException ex) {
            System.out.println("add/edit contact Exception");
            ex.printStackTrace();
        }

        request.getSession().setAttribute("personId", request.getParameter("personId"));

        return model;
    }

}