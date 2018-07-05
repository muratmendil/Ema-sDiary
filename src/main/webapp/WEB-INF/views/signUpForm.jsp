<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <div class="login-form-container">
  		<div class="jumbotron">
  		    <c:url var="signUpUrl" value="/signUp" />
  			<form:form action="${signUpUrl}" method="post" modelAttribute="user">
  				<h3 class="text-center">Inscription</h3>
  				<br>
  				 <div class="form-group">
				    <form:label path="firstName" for="exampleFormControlInput1">Prenom</form:label>
				    <form:input path="firstName" class="form-control" id="exampleFormControlInput1" name="firstName" placeholder="name@example.com" />
				 </div>
				  <div class="form-group">
				    <form:label path="lastName" for="exampleFormControlInput1">Nom</form:label>
				    <form:input path="lastName" class="form-control" id="exampleFormControlInput1" name="lastName" placeholder="******"/>
				  </div>
  				 <div class="form-group">
				    <form:label path="email" for="exampleFormControlInput1">Email </form:label>
				    <form:input path="email" class="form-control" id="exampleFormControlInput1" name="email" placeholder="name@example.com"/>
				 </div>
				 
				 <div class="form-group">
				    <form:label path="birthDate" for="exampleFormControlInput1">Naissance</form:label>
				    <form:input path="birthDate" class="form-control" id="exampleFormControlInput1" name="birthDay" placeholder="******"/>
				  </div>
				  <div class="form-group">
				    <form:label path="password" for="exampleFormControlInput1">Password</form:label>
				    <form:input path="password" class="form-control" id="exampleFormControlInput1" name="password" placeholder="******"/>
				  </div>
				    <form:button type="submit" class="btn btn-primary">S'inscrire</form:button>
  			</form:form>
  		</div>
 </div>
