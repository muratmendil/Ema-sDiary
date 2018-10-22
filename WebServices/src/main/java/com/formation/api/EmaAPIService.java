package com.formation.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import com.formation.exeption.ErrorExeption;
import com.formation.facade.Facade;
import com.formation.model.User;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/ema")
public class EmaAPIService {

	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrackInJSON() {
		User user2 = new User();
		try {
			user2 =  Facade.getInstance().getUserService().findByEmail("dadie.emilin@gmail.com", "azerty");
			System.out.println(user2.toString());
		} catch (ErrorExeption e) {
			
		}
		return Response.status(200).entity(user2).build();
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response loginUser(
			 @QueryParam("email") String email,
			 @QueryParam("password") String password){
		User user = null;
		try {
			user =  Facade.getInstance().getUserService().findByEmail(email, password);
		} catch (ErrorExeption e) {
			user = null;
			return Response.status(200).entity(user).build();
		}
		return Response.status(200).entity(user).build();
	 }
	
	
	@POST
	@Path("/signUp")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response signUpUser(
			 @QueryParam("firstName") String firstName,
			 @QueryParam("lastName") String lastName,
			 @QueryParam("email") String email,
			 @QueryParam("password") String password,
			 @QueryParam("birthDate") String birthDate,
			 @QueryParam("role") String role
			 ){
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setBirthDate(birthDate);
		user.setRole(role);
		try {
			user =  Facade.getInstance().getUserService().createUser(user);
		} catch (ErrorExeption e) {
			user = null;
			return Response.status(200).entity(user).build();
		}
		return Response.status(200).entity(user).build();
	 }
}


