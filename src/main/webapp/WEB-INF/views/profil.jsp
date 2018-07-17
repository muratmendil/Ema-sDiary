<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="row">
	<div class="col-xs-12 col-sm-6 col-md-6">
		<div class="well well-sm">
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<img src="http://placehold.it/380x500" alt=""
						class="img-rounded img-responsive" />
				</div>
				<div class="col-sm-6 col-md-8">

					<h4>${users.lastName}</h4>
					<h4>${users.birthDate}</h4>
						<small><cite title="San Francisco, USA">San
								Francisco, USA <i class="glyphicon glyphicon-map-marker"> </i>
						</cite></small>
						<p>
							<i class="glyphicon glyphicon-envelope"></i>${users.lastName}<br />
							<i class="glyphicon glyphicon-globe"></i><a
								href="http://www.jquery2dotnet.com">${users.password}</a> <br />
							<i class="glyphicon glyphicon-gift"></i> ${users.id}
						</p>
						<!-- Split button -->
						<div class="btn-group">
							<button type="button" class="btn btn-primary">Social</button>
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">
								<span class="caret"></span><span class="sr-only">Social</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Twitter</a></li>
								<li><a href="https://plus.google.com/+Jquery2dotnet/posts">Google
										+</a></li>
								<li><a href="https://www.facebook.com/jquery2dotnet">Facebook</a></li>
								<li class="divider"></li>
								<li><a href="#">Github</a></li>
							</ul>
						</div>
				</div>
			</div>
			<a href="<c:url value='/logout' />">Logout</a> 
		</div>
	</div>
</div>
