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
	
		<%@ include file="../Menu.jsp" %>
			
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nome</th>
      <th scope="col">Descrição</th>
      <th scope="col">Status</th>
      
    </tr>
  </thead>
  <tbody>
  
  		<%
  			IFabricaConexoes fabrica = new FabricaConexoesPostegres();
  			ITemadao temadao = new TemadaoPostegres(fabrica.obterConexao());
  			
  			List<Tema> listarTemas = temadao.listar();
  			
  			for (Tema tema : listarTemas){
  				
  		%>
  
    <tr>
      <td><%=tema.getId()%></td>
      <td><%=tema.getNome()%></td>
      <td><%=tema.getDescricao()%></td>
      <td><%=tema.getStatus()%></td>
      <td>
      	<a class="btn btn-warning" role="button" href="<%=request.getContextPath()%>/tema/AlterarTema.jsp?id=<%=tema.getId()%>">Alterar</a>
      	<a class="btn btn-danger" role="button" href="<%=request.getContextPath()%>/tema/ExcluirTema.jsp?id=<%=tema.getId()%>">Excluir</a>
      </td>
    </tr>
    
    <% } %>
    
  </tbody>
</table>
		
	</body>
</html>