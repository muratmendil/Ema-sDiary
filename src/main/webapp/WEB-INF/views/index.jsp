<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Employee</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/signIn.css' />">
	
<link rel="stylesheet" type="text/css"
href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />">

</head>
<body>
	<%@ include file="logic/loginForm.jsp"%>
	<a href="<c:url value='profil' />">Profil</a>
	<a href="<c:url value='article' />">Article</a>
</body>
</html>
