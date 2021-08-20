<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import= "br.edu.ifs.modelo.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
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
			<h2>Alterar Usuário</h2>
			
		<form method="post" action="<%=request.getContextPath()%>/ExcluirUsuario.do">
			
			<input type="hidden" name="id" values="<%=usuario.getId()%>">
			<p> Nome: <%=usuario.getNome() %> </p>
			<p> Login: <%=usuario.getLogin() %> </p>
			<br>
			<input type="submit"  class="btn btn-success" values="Excluir Usuário">
			
		</form>
		
		<%@ include file="Rodape.jsp" %>
	</body>
</html>