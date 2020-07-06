<!DOCTYPE html>
<% 
System.out.println( "Enter welcome.jsp..." );
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />

	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Home</a>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h2>${message}</h2>
		</div>

	</div>

	<script type="text/javascript" src="/css/bootstrap.min.css"></script>

</body>

</html>