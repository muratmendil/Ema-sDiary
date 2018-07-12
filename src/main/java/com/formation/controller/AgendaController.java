package com.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.formation.model.Objectif;
import com.formation.service.ObjectifService;

@Controller
@SessionAttributes("objectifs")
public class AgendaController {
	
	  
	  @Autowired
	  private ObjectifService objectifService;
	 
	  /*
	  @RequestMapping(value = "home", method = RequestMethod.GET)
	    public String homePage(ModelMap model) {
	        return "home";
	  }*/
	  
	  @RequestMapping(value = "home", method = RequestMethod.GET)
	    public String calendarPage(ModelMap model) {
		  	List<Objectif> objectifs = objectifService.getAll();
	        model.addAttribute("objectifs", objectifs);
	        return "home";
	  }
}
