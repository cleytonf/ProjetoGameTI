<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import="br.edu.ifs.modelo.*"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> GameTI - Erro</title>
	</head>
	<body>
		
		<%
			String descricaoErro = (String) request.getSession().getAttribute("erro");
		%>
		
		<p><%=descricaoErro %></p>
		
	</body>
</html>