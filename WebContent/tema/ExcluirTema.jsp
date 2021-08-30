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
			<h2>Excluir Tema</h2>
			
		<form method="post" action="<%=request.getContextPath()%>/ExcluirTema.do">
			
			<input type="hidden" name="id" value="<%=tema.getId()%>">
			<p> Nome: <%=tema.getNome() %> </p>
			<p> Descrição: <%=tema.getDescricao() %> </p>
			<br>
			<input type="submit"  class="btn btn-success" value="Excluir Tema">
			
		</form>
		
		<%@ include file="../Rodape.jsp" %>
	</body>
</html>