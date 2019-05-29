package com.formation.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@Autowired UserService userService;
	
	@Autowired ObjectifService objectifService;

	@GetMapping("user/{id}/objectifs")
	public ResponseEntity<List<Objectif>> getObjectifs(@PathVariable(value = "id") int id){
		List<Objectif> objectifs = new ArrayList<>();			
		try {
			User user =  userService.findById(id);
			try {
			   objectifs = objectifService.findAllByUserId(id);
		      return ResponseEntity.ok(objectifs);

			} catch (ErrorExeption e) {
				throw e;
			} 
		} catch (ErrorExeption e1) {
		      return ResponseEntity.ok(objectifs);
		}
	 }
	
	 @PostMapping("/newObjectif")
	 public ResponseEntity<Objectif> createObjectif(@Valid @RequestBody Objectif objectif){
		try {
			Objectif newObjectif =  objectifService.createObjectif(objectif);
			return ResponseEntity.ok(newObjectif);
		} catch (ErrorExeption e) {
			return ResponseEntity.ok(new Objectif());
		} 
	 }
}







