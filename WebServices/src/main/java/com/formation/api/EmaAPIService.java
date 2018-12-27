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

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

@Path("/ema")
public class EmaAPIService {
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response loginUser(User user){
		try {
			User newUser =  Facade.getInstance().getUserService().findByEmail(user.getEmail(), user.getPassword());
			return Response.ok().entity(newUser).build();
		} catch (ErrorExeption e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(e.getExeptionMessage()).build();
		} 
	 }
	
	@POST
	@Path("/signUp")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response signUpUser(User user){
		try {
			user =  Facade.getInstance().getUserService().createUser(user);
			return Response.status(201).entity(user).build();
		} catch (ErrorExeption e) {
			return Response.status(Response.Status.CONFLICT).entity(e.getExeptionMessage()).build();
		} 
	 }
	
	@GET
	@Path("user/{id}/objectifs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObjectifs(@PathParam("id") int id){
		List<Objectif> objectifs = new ArrayList<>();			
		try {
			User user =  Facade.getInstance().getUserService().findById(id);
			try {
			   objectifs =  Facade.getInstance().getObjectifService().findByUserId(id);
		       return Response.status(200).entity(objectifs).build();
			} catch (ErrorExeption e) {
				String message = e.getExeptionMessage();
				return Response.status(200).entity(message).build();
			} 
		} catch (ErrorExeption e1) {
			return Response.status(200).entity(objectifs).build();
		}
	 }
	
	@GET
	@Path("user/{id}/objectifs/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObjectifsTask(@PathParam("id") int id){
		List<Task> tasks = new ArrayList<>();

		try {
			User user =  Facade.getInstance().getUserService().findById(id);
			try {
				tasks =  Facade.getInstance().getTaskService().findByUserId(id);

			    final GenericEntity<List<Task>> entity
			        = new GenericEntity<List<Task>>(tasks) {};
				return Response.status(200).entity(entity).build();

			} catch (ErrorExeption e) {
				String message = e.getExeptionMessage();
				return Response.status(200).entity(tasks).build();
			}
		} catch (ErrorExeption e1) {
			return Response.status(200).entity(tasks).build();
		}
	 }
	
	
	@GET
	@Path("user/{userId}/objectif/{objectifId}/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObjectifTask(@PathParam("userId") int userId, @PathParam("objectifId") int objectifId){
		List<Task> tasks = new ArrayList<>();
		try {
			User user =  Facade.getInstance().getUserService().findById(userId);
			try {
				tasks =  Facade.getInstance().getTaskService().findByObjectifId(objectifId);
				return Response.status(200).entity(tasks).build();

			} catch (ErrorExeption e) {
				return Response.status(200).entity(tasks).build();
			}
		} catch (ErrorExeption e1) {
			return Response.status(200).entity(tasks).build();
		}
	 }
	
	
	@POST
	@Path("/newTask")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response createTask(Task task){
		try {
			Task newTask =  Facade.getInstance().getTaskService().createTask(task);
			return Response.ok().entity(newTask).build();
		} catch (ErrorExeption e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(e.getExeptionMessage()).build();
		} 
	 }
	
	@DELETE
	@Path("/deleteTask/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response deleteTask(@PathParam("id") int id){
			 Facade.getInstance().getTaskService().deleteTask(id);
			 return Response.ok().entity(true).build();
	 }
	
	@POST
	@Path("/newObjectif")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response createObjectif(Objectif objectif){
		try {
			Objectif newObjectif =  Facade.getInstance().getObjectifService().createObjectif(objectif);
			return Response.ok().entity(newObjectif).build();
		} catch (ErrorExeption e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(e.getExeptionMessage()).build();
		} 
	 }
}


