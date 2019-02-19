package com.formation.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exeption.ErrorExeption;
import com.formation.model.Objectif;
import com.formation.model.User;
import com.formation.service.ObjectifService;
import com.formation.service.UserService;

@RestController
public class ObjectifApi {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectifService objectifService;
	
	
	@GetMapping("user/{id}/objectifs")
	public List<Objectif> getObjectifs(@PathVariable(value = "id") int id){
		List<Objectif> objectifs = new ArrayList<>();			
		try {
			User user =  userService.findById(id);
			try {
			   objectifs =  objectifService.findAllByUserId(id);
			   return objectifs;
			} catch (ErrorExeption e) {
				String message = e.getExeptionMessage();
				return objectifs;
			} 
		} catch (ErrorExeption e1) {
			return objectifs;
		}
	 }
	
	
	 @PostMapping("/newObjectif")
	 public Objectif createObjectif(@Valid @RequestBody Objectif objectif){
		try {
			Objectif newObjectif =  objectifService.createObjectif(objectif);
			return newObjectif;
		} catch (ErrorExeption e) {
			return new Objectif();
		} 
	 }
}
