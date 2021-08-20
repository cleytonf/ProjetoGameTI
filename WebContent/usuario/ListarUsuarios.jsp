<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import="br.edu.ifs.modelo.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>GameTI</title>
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.5.3-dist/css/bootstrap.min.css">
		
	</head>
	<body>
	
		<%@ include file="Menu.jsp" %>
			
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nome</th>
      <th scope="col">Email</th>
      <th scope="col">Login</th>
      <th scope="col">Ações</th>
    </tr>
  </thead>
  <tbody>
  
  		<%
  			IFabricaConexoes fabrica = new FabricaConexoesPostegres();
  			IUsuariodao usuariodao = new UsuariodaoPostegres(fabrica.obterConexao());
  			
  			List<Usuario> listarUsuarios = usuariodao.listar();
  			
  			for (Usuario usuario : listarUsuarios){
  				
  		%>
  
    <tr>
      <td><%=usuario.getId()%></td>
      <td><%=usuario.getNome()%></td>
      <td><%=usuario.getEmail()%></td>
      <td><%=usuario.getLogin()%></td>
      <td>
      	<a class="btn btn-warning" role="button" href="<%=request.getContextPath()%>/usuario/AlterarUsuario.jsp?id=<%=usuario.getId()%>">Alterar</a>
      	<a class="btn btn-danger" role="button" href="<%=request.getContextPath()%>/usuario/ExcluirUsuario.jsp?id=<%=usuario.getId()%>">Excluir</a>
      </td>
    </tr>
    
    <% } %>
    
  </tbody>
</table>
		
	</body>
</html>