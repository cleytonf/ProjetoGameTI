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
      <th scope="col">Usuario_id</th>
      <th scope="col">Tema_id</th>
      <th scope="col">Descrição</th>
      <th scope="col">Alternativa_1</th>
      <th scope="col">Alternativa_2</th>
      <th scope="col">Alternativa_3</th>
      <th scope="col">Alternativa_4</th>
      <th scope="col">Gabarito</th>
      <th scope="col">Status</th>
      
    </tr>
  </thead>
  <tbody>
  
  		<%
  			IFabricaConexoes fabrica = new FabricaConexoesPostegres();
  			IPerguntadao perguntadao = new PerguntadaoPostegres(fabrica.obterConexao());
  			
  			List<Pergunta> listarPerguntas = perguntadao.listar();
  			
  			for (Pergunta pergunta : listarPerguntas){
  				
  		%>
  
    <tr>
      <td><%=pergunta.getId()%></td>
      <td><%=pergunta.getUsuario_id()%></td>
      <td><%=pergunta.getTema_id()%></td>
      <td><%=pergunta.getDescricao()%></td>
      <td><%=pergunta.getAlternativa_1()%></td>
      <td><%=pergunta.getAlternativa_2()%></td>
      <td><%=pergunta.getAlternativa_3()%></td>
      <td><%=pergunta.getAlternativa_4()%></td>
      <td><%=pergunta.getGabarito()%></td>
      <td><%=pergunta.getStatus()%></td>
      <td>
      	<a class="btn btn-warning" role="button" href="<%=request.getContextPath()%>/pergunta/AlterarPergunta.jsp?id=<%=pergunta.getId()%>">Alterar</a>
      	<a class="btn btn-danger" role="button" href="<%=request.getContextPath()%>/pergunta/ExcluirPergunta.jsp?id=<%=pergunta.getId()%>">Excluir</a>
      </td>
    </tr>
    
    <% } %>
    
  </tbody>
</table>
		
	</body>
</html>