package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.*;
//import org.springframework.web.servlet.mvc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainClass {

	@RequestMapping(value={"/", "/Menu"})
	public ModelAndView Menu(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("MainClass");
        model.addObject("title", "Mini Registration System");

        return model;
	}
}