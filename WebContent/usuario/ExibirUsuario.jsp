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
	
		<%@ include file="Menu.jsp" %>

		<%
		
			int id = Integer.parseInt(request.getParameter("id").toString());
			Usuario usuario = new Usuario();
			
			try {
				
				IFabricaConexoes fabrica = new FabricaConexoesPostegres();
				IUsuariodao usuariodao = new UsuariodaoPostegres(fabrica.obterConexao());
				usuario = usuariodao.recuperar(id);
				
			}
			catch (Exception e){
				
				request.getSession().setAttribute("erro", e.getMessage().toString());
				response.sendRedirect("../erro/ExibirErro.jsp");
				
			}
		%>

		<p>Nome do Usuário: <%=usuario.getNome() %></p>
		<p>Login do Usuário: <%=usuario.getLogin() %></p>

		<%@ include file="Rodape.jsp" %>

	</body>
</html>