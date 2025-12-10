<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table de multiplication</title>
</head>

<style>
	.error {
		display : flex;
		justify-content : center;
		align-items : center
	}
	.error p {
		color : red;		
	}
	
	.Containt {
		font-size : small
	}
</style>
<body class="Containt">
	<%
		String nombreArg = request.getParameter("table");
		
		if(nombreArg != null && !nombreArg.isEmpty()) {
			int nombre = Integer.parseInt(nombreArg);
	%>
	
	<h5>Table de multiplication de <%= nombre %></h5>
	
	<%
			for (int i = 0; i <= 10; i++) {
				out.println(nombre + " × " + i + " = " + (nombre * i) + "<br>");
			}
		} else {
	%>
	
	<div class="error">
		<p>Le paramètre table n'est pas défini!</p>
	</div>
	
	<%
		}
	%>
</body>
</html>