<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="login-form-container">
	<div class="jumbotron">
		<c:url var="loginUrl" value="/index" />
		<form:form action="${loginUrl}" method="post" modelAttribute="user">
			<h3 class="text-center">Connexion</h3>
  				<br>
  				 <div class="form-group">
				    <form:label path="email" for="exampleFormControlInput1">Email </form:label>
				    <form:input path="email" class="form-control" id="exampleFormControlInput1" name="email" placeholder="name@example.com"/>
				 </div>
				  <div class="form-group">
				    <form:label path="password" for="exampleFormControlInput1">Password</form:label>
				    <form:input path="password" class="form-control" id="exampleFormControlInput1" name="password" placeholder="******"/>
				  </div>
				   <form:button type="submit" class="btn btn-primary">Se Connecter</form:button>
		</form:form>
		<a href="<c:url value='signUp' />">Vous n'avez pas de compte? inscription</a>
	</div>
</div>
