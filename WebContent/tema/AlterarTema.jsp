<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import= "br.edu.ifs.modelo.Tema" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
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
			<h2>Alterar Tema</h2>
			
		<form method="post" action="<%=request.getContextPath()%>/AlterarTema.do">
			
			<input type="hidden" name="id" value="<%=tema.getId()%>">
			<label for="nome">Nome:</label>
			<input type="text" id="nome" name="nome" value="<%=tema.getNome()%>">
			<br>
			<label for="nome">Descrição:</label>
			<input type="text" id="descricao" name="descricao" value="<%=tema.getDescricao()%>">
			<br>
			<label for="nome">Status:</label>
			<input type="text" id="status" name="status" value="<%=tema.getStatus()%>">
			<br>
			<input type="submit" value="Alterar Tema">
		</form>
		
		<%@ include file="../Rodape.jsp" %>
	</body>
</html>