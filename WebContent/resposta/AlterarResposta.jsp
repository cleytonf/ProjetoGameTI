<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import= "br.edu.ifs.modelo.*" %>
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
			Resposta resposta = new Resposta();
			
try {
				
				IFabricaConexoes fabrica = new FabricaConexoesPostegres();
				IRespostadao respostadao = new RespostadaoPostegres(fabrica.obterConexao());
				resposta = respostadao.recuperar(id);
				
			}
			catch (Exception e){
				
				request.getSession().setAttribute("erro", e.getMessage().toString());
				response.sendRedirect("../erro/ExibirErro.jsp");
				
			}
		%>
			<h2>Alterar Resposta</h2>
			
		<form method="post" action="<%=request.getContextPath()%>/AlterarResposta.do">
			
			<input type="hidden" name="id" value="<%=resposta.getId()%>">
			
			<br>
			<label for="pergunta_id">Pergunta_id:</label>
			<input type="text" id="pergunta_id" name="pergunta_id" value="<%=resposta.getPergunta_id()%>">
			<br>
			<label for="alternativa">Alternativa:</label>
			<input type="text" id="alternativa" name="alternativa" value="<%=resposta.getAlternativa() %>">
			<br>
			<input type="submit" value="Alterar Resposta">
		</form>
		
		<%@ include file="../Rodape.jsp" %>
	</body>
</html>