package com.app;

import com.model.*;
import com.service.*;
import com.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.*;
//import org.springframework.web.servlet.mvc.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;

import java.util.*;
import java.text.*;
import java.text.DateFormat;

@RestController
@RequestMapping("/Person")
public class AddPerson {

    private CRUD<PersonDTO> personCRUD;

    @Autowired
    public AddPerson(CRUD<PersonDTO> personCRUDParam) {
        personCRUD = personCRUDParam;
    }
    
    @GetMapping("/getList")
    public List<PersonDTO> getList() {
        return personCRUD.read(SortValue.SORT_LASTNAME_ASC);
    }

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        ModelAndView model = new ModelAndView("ListPerson");
        List<PersonDTO> lstPerson = personCRUD.read(SortValue.SORT_LASTNAME_ASC);
        model.addObject("people", lstPerson);

        return model;
        
        //return new ModelAndView("ListPerson");
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("AddPerson");

        return model;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("AddPerson");
        PersonDTO editPerson = personCRUD.get(Integer.parseInt(request.getParameter("editId")));
        model.addObject("person", editPerson);

        return model;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("redirect:/Person/list");
        personCRUD.delete(Integer.parseInt(request.getParameter("deleteId")));
    
        return model;
    }

    @RequestMapping("/submit")
    public ModelAndView submit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("redirect:/Person/list");
        PersonDTO newPerson = new PersonDTO();
        PersonName newPersonName = new PersonName();
        PersonAddress newPersonAddress = new PersonAddress();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        PersonGender gender = null;

        try{
            if(!request.getParameter("id").equals("") && request.getParameter("id") != null) {
                newPerson = personCRUD.get(Integer.parseInt(request.getParameter("id")));
                newPersonAddress = newPerson.getAddress();
            }
            newPersonName.setFirstName(request.getParameter("firstname"));
            newPersonName.setLastName(request.getParameter("lastname"));
            newPersonName.setMiddleName(request.getParameter("middlename"));
            newPersonName.setSuffix(request.getParameter("suffix"));
            newPersonName.setTitle(request.getParameter("title"));

            newPersonAddress.setStreetNumber(Integer.parseInt(request.getParameter("streetnumber")));
            newPersonAddress.setBarangay(request.getParameter("barangay"));
            newPersonAddress.setCity(request.getParameter("city"));
            newPersonAddress.setZipCode(Integer.parseInt(request.getParameter("zipcode")));

            newPerson.setName(newPersonName);
            newPerson.setBirthday(df.parse(request.getParameter("birthday")));
            newPerson.setGWA(new Float(request.getParameter("gwa")));
            newPerson.setDateHired(df.parse(request.getParameter("datehired")));
            newPerson.setCurrentlyEmployed(new Boolean(request.getParameter("employed")));

            switch(request.getParameter("gender")) {
                case "MALE" : case "male" :
                    gender = PersonGender.MALE;
                    break;
                case "FEMALE" : case "female" :
                    gender = PersonGender.FEMALE;
                    break;
            }

            newPerson.setGender(gender);
            newPerson.setAddress(newPersonAddress);

            if(newPerson.getId() != 0) {
                personCRUD.update(newPerson);
            }
            else  {
                personCRUD.create(newPerson);
            }
        }
        catch(IllegalArgumentException | NullPointerException | ParseException ex) {
            System.out.println("add/edit person Exception");
            ex.printStackTrace();
        }

        return model;
    }

}