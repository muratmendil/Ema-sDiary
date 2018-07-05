<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<style type="text/css"></style>
<title>Add Employee</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/signIn.css' />">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="loginForm.jsp"%>
	<a href="<c:url value='signUp' />">Inscription</a>
	<a href="<c:url value='profil' />">Profil</a>
	<a href="<c:url value='article' />">Article</a>
</body>
</html>
