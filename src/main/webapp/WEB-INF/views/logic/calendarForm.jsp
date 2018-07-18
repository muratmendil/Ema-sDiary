<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" tabindex="-1" role="dialog" id="modal1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Create new event</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="name">Nom</label>
                        <input type="text" name="name" id="name" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="starts-at">Starts at</label>
                        <input type="text" name="starts_at" id="starts-at" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="ends-at">Ends at</label>
                        <input type="text" name="ends_at" id="ends-at" />
                    </div>
                </div>
                 <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="place">Place</label>
                        <input type="text" name="place" id="place" />
                    </div>
                </div>
                
                 <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="priority">Priorié</label>
                        <input type="text" name="prority" id="priority" />
                    </div>
                </div>
                 <div class="row">
                    <div class="col-xs-12">
                        <label class="col-xs-4" for="objectif">Objectifs</label>
		                <select name="objectif">
		                  <option value="Greece" selected="selected">Aucun</option>
						 
						</select>
					</div>
				 </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="newObjectifButton" class="btn btn-default">Créer un objectif
               </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save-event">Save changes</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" tabindex="-1" role="dialog" id="modal2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal2" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Create new event</h4>
            </div>
            <c:url var="homeUrl" value="/home" />
           <form:form action="${loginUrl}" method="post" modelAttribute="objectif">
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form:label path="name" for="exampleFormControlInput1">Nom objectif</form:label>
				    	<form:input path="name" class="form-control" id="exampleFormControlInput1" name="name"/>
                    </div>
                </div>
			</div>
            <div class="modal-footer">
   				<form:button type="submit" id="newObjectifButton" class="btn btn-primary">Creer un objectif</form:button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save-event">Save changes</button>
            </div>
            </form:form>
        </div>
    </div>
</div>