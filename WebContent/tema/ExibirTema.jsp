<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.modelo.*" %>
<%@ page import="br.edu.ifs.dao.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>GameTI</title>
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.5.3-dist/css/bootstrap.min.css">
		
	</head>
	<body>
	
		<%@ include file="../Menu.jsp" %>

		<%
		
			int id = Integer.parseInt(request.getParameter("id").toString());
			Tema tema = new Tema();
			
			try {
				
				IFabricaConexoes fabrica = new FabricaConexoesPostegres();
				ITemadao temadao = new TemadaoPostegres(fabrica.obterConexao());
				tema = temadao.recuperar(id);
				
			}
			catch (Exception e){
				
				request.getSession().setAttribute("erro", e.getMessage().toString());
				response.sendRedirect("../erro/ExibirErro.jsp");
				
			}
		%>

		<p>Nome do Tema: <%=tema.getNome() %></p>
		<p>Descrição do Tema: <%=tema.getDescricao()%></p>

		<%@ include file="../Rodape.jsp" %>

	</body>
</html>