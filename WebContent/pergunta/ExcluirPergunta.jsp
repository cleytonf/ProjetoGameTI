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
			Pergunta pergunta = new Pergunta();
			
try {
				
				IFabricaConexoes fabrica = new FabricaConexoesPostegres();
				IPerguntadao perguntadao = new PerguntadaoPostegres(fabrica.obterConexao());
				pergunta = perguntadao.recuperar(id);
				
			}
			catch (Exception e){
				
				request.getSession().setAttribute("erro", e.getMessage().toString());
				response.sendRedirect("../erro/ExibirErro.jsp");
				
			}
		%>
			<h2>Excluir Pergunta</h2>
			
		<form method="post" action="<%=request.getContextPath()%>/ExcluirPergunta.do">
			
			<input type="hidden" name="id" value="<%=pergunta.getId()%>">
			<p> Descrição: <%=pergunta.getDescricao() %> </p>
			<br>
			<input type="submit"  class="btn btn-success" value="Excluir Pergunta">
			
		</form>
		
		<%@ include file="../Rodape.jsp" %>
	</body>
</html>