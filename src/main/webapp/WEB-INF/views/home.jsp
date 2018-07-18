<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>Add Employee</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	  <!-- Latest compiled and minified JavaScript -->
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<link rel="stylesheet"
			href="<c:url value='/resources/css/vendor/bootstrap.min.css'/>">  
		<link rel="stylesheet"
			href="<c:url value='/resources/css/vendor/fullcalendar.css'/>">
		<link rel="stylesheet" 
			href="<c:url value='/resources/css/vendor/bootstrap-datetimepicker.min.css'/>">
		<script type="text/javascript" src="<c:url value='/resources/js/vendor/moment-with-locales.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/vendor/fullcalendar.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/vendor/bootstrap-datetimepicker.min.js'/>"></script>

	<style>
	
	The basics of fullCalendar 3
		#calendar {
		width: 80%;
		display: block;
		margin-left: auto;
		margin-right: auto;
		}
	
		.centered {
		text-align: center;
		}
		
	</style>
</head>
<body>
	<h1 class="centered">A basic instance of fullCalendar</h1>
	<!-- The calendar container -->
	<div id="calendar"></div>
	<div id='datepicker'></div>
	<%@ include file="logic/calendarForm.jsp" %>
  	<%@ include file="logic/calendarLogic.jsp" %>
</body>
</html>
