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
			
		<form method="post" action="<%=request.getContextPath()%>/AlterarUsuario.do">
			<label for="nome">Nome:</label>
			<input type="hidden" name="id" values="<%=usuario.getId()%>">
			<input type="text" id="nome" name="nome" values="<%=usuario.getNome()%>">
			<br>
			<label for="nome">Email:</label>
			<input type="text" id="email" name="email" values="<%=usuario.getEmail()%>">
			<br>
			<br>
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" values="<%=usuario.getLogin()%>">
			<br>
			<br>
			<label for="senha">Senha:</label>
			<input type="password" id="senha" name="senha" values="<%=usuario.getSenha()%>">
			<br>
			<br>
			<input type="submit" value="Alterar Usuário">
		</form>
		
		<%@ include file="Rodape.jsp" %>
	</body>
</html>