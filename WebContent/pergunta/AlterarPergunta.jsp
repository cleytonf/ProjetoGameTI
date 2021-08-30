<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import= "br.edu.ifs.modelo.Pergunta" %>
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
			<h2>Alterar Pergunta</h2>
			
		<form method="post" action="<%=request.getContextPath()%>/AlterarPergunta.do">
			
			<input type="hidden" name="id" value="<%=pergunta.getId()%>">
			
			
			<br>
			<label for="nome">Tema_id:</label>
			<input type="text" id="tema_id" name="tema_id" value="<%=pergunta.getTema_id()%>">
			<br>
			<label for="nome">Descrição:</label>
			<input type="text" id="descricao" name="descricao" value="<%=pergunta.getDescricao()%>">
			<br>
			<label for="nome">Alternativa_1:</label>
			<input type="text" id="alternativa_1" name="alternativa_1" value="<%=pergunta.getAlternativa_1()%>">
			<br>
			<label for="nome">Alternativa_2:</label>
			<input type="text" id="alternativa_2" name="alternativa_2" value="<%=pergunta.getAlternativa_2()%>">
			<br>
			<label for="nome">Alternativa_3:</label>
			<input type="text" id="alternativa_3" name="alternativa_3" value="<%=pergunta.getAlternativa_3()%>">
			<br>
			<label for="nome">Alternativa_4:</label>
			<input type="text" id="alternativa_4" name="alternativa_4" value="<%=pergunta.getAlternativa_4()%>">
			<br>
			<label for="nome">Gabarito:</label>
			<input type="text" id="gabarito" name="gabarito" value="<%=pergunta.getGabarito()%>">
			<br>
			<label for="nome">Status:</label>
			<input type="text" id="status" name="status" value="<%=pergunta.getStatus()%>">
			<br>
			<input type="submit" value="Alterar Pergunta">
		</form>
		
		<%@ include file="../Rodape.jsp" %>
	</body>
</html>