package com.formation.api;

import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.formation.exeption.ErrorExeption;
import com.formation.facade.Facade;
import com.formation.model.Objectif;
import com.formation.model.Task;
import com.formation.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.core.MediaType;

@Path("/ema")
public class EmaAPIService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrackInJSON() {

		User user = new User();
		user.setFirstName("Emilin");
		user.setLastName("DADIE");
		user.setEmail("dadie.emilin@gmail.com");
		user.setPassword("azerty");
		user.setBirthDate("7 mars");
		user.setRole("admin");

		return Response.status(200).entity(user).build();
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser(User user) {

		User newUser = new User();
		try {
			System.out.println("Enter" + user);
			user.setBirthDate("7 mars");
			user.setFirstName("Emilin");
			user.setLastName("Dadie");
			user.setRole("admin");
			newUser = Facade.getInstance().getUserService().findByEmail(user.getEmail(), user.getPassword());
		} catch (ErrorExeption e) {
			e.getMessage();
		}
		return Response.status(200).entity(newUser).build();

	}

	@POST
	@Path("/signUp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signUpUser(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
			@QueryParam("email") String email, @QueryParam("password") String password,
			@QueryParam("birthDate") String birthDate, @QueryParam("role") String role) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setBirthDate(birthDate);
		user.setRole(role);
		try {
			user = Facade.getInstance().getUserService().createUser(user);
		} catch (ErrorExeption e) {
			user = null;
			return Response.status(200).entity(user).build();
		} catch (ErrorExeption e) {
			return Response.status(200).entity(e.getExeptionMessage()).build();
		} 
	 }
	
	
	@GET
	@Path("user/{id}/objectifs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObjectifs(@PathParam("id") int id){
			try {
				User user =  Facade.getInstance().getUserService().findById(id);
				List<Objectif> objectifs = new ArrayList<>();
				try {
					objectifs =  Facade.getInstance().getObjectifService().findByUserId(id);
					return Response.status(200).entity(objectifs).build();

				} catch (ErrorExeption e) {
					return Response.status(500).entity(e.getExeptionMessage()).build();
				} 
			} catch (ErrorExeption e1) {
				return Response.status(401).entity(e1.getExeptionMessage()).build();
			}
	 }
	
	@GET
	@Path("user/{userId}/objectif/{objectifId}/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObjectifTask(@PathParam("userId") int userId, @PathParam("objectifId") int objectifId){
		try {
			User user =  Facade.getInstance().getUserService().findById(userId);
			List<Task> tasks = new ArrayList<>();
			try {
				tasks =  Facade.getInstance().getTaskService().findByObjectifId(objectifId);
				return Response.status(200).entity(tasks).build();

			} catch (ErrorExeption e) {
				return Response.status(200).entity(e.getExeptionMessage()).build();
			}
		} catch (ErrorExeption e1) {
			return Response.status(401).entity(e1.getExeptionMessage()).build();
		}
		return Response.status(200).entity(user).build();
	}
}
