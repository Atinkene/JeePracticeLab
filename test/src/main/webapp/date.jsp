<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>

<style>
	html {
		background-image : linear-gradient(180deg,red,yellow); 
		/* background : ; */
		background-repeat : no-repeat
	}
	.date {
		color : red;
		font-weight: bold; 
	}
</style>

<body>
	<h1>Date du jour</h1>	
	<p>
		Nous sommes le <span class="date"> <%= new Date().toLocaleString() %> </span>
	</p>
</body>
</html>