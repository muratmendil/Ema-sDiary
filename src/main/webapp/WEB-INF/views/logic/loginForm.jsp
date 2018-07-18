<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html">
<h:head>
	<title>login</title>
</h:head>
<h:body>
		<h:form>
		<h3>JSF Login Logout</h3>
		<h:outputText value="Username" />
		<h:inputText id="username" value="#{login.user}"></h:inputText>
		<h:message for="username"></h:message>
		<br></br><br></br>
		
		<h:outputText value="Password" />
		<h:inputSecret id="password" value="#{login.pwd}"></h:inputSecret>
		<h:message for="password"></h:message>
		<br></br><br></br>
		
		<h:commandButton action="#{login.validateUsernamePassword}"
			value="Login"></h:commandButton>
	</h:form>
</h:body>

</html>
