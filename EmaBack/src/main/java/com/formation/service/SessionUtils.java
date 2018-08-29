package com.formation.service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.formation.model.User;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
  
  
public class SessionUtils {
     
    private static SessionUtils instance;
     
    public static SessionUtils getInstance(){
         if (instance == null){
             instance = new SessionUtils();
         }
          
         return instance;
    }
     
    private SessionUtils(){
          
    }
     
    private ExternalContext currentExternalContext(){
         if (FacesContext.getCurrentInstance() == null){
             throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
         }else{
             return FacesContext.getCurrentInstance().getExternalContext();
         }
    }
     
    public User getCurrentUser(){
         return (User) getAttribute("current_user");
    }
     
    public void setCurrentUser(User user){
         setAttribute("current_user", user);
    }
     
    public void encerrarSessao(){   
         currentExternalContext().invalidateSession();
    }
     
    public Object getAttribute(String name){
         return currentExternalContext().getSessionMap().get(name);
    }
     
    public void setAttribute(String name, Object value){
         currentExternalContext().getSessionMap().put(name, value);
    }

    
    public void removeAttribute(String attribute){
    	removeAttribute(attribute);
    }
	public void invalide(){   
        currentExternalContext().invalidateSession();
   }
}