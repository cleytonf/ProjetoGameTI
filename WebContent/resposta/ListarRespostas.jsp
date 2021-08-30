<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import="br.edu.ifs.modelo.*"%>
<%@ page import="br.edu.ifs.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>GameTI</title>
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.5.3-dist/css/bootstrap.min.css">
		
	</head>
	<body>
	
		<%@ include file="../MenuLogado.jsp" %>
			<div class="container">
			<br>
			<a class="btn btn-success" role="button" href="<%=request.getContextPath()%>/resposta/CadastrarResposta.jsp">Cadastrar</a>
			<br>		
			
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Usuario_id</th>
      <th scope="col">Pergunta_id</th>
      <th scope="col">Alternativa</th>
      <th scope="col">Data_Resposta</th>
      <th scope="col"></th>
      
    </tr>
  </thead>
  <tbody>
  
  		<%
  			IFabricaConexoes fabrica = new FabricaConexoesPostegres();
  			IRespostadao respostadao = new RespostadaoPostegres(fabrica.obterConexao());
  			
  			List<Resposta> listarRespostas = respostadao.listar();
  			
  			for (Resposta resposta : listarRespostas){
  				
  		%>
  
    <tr>
      <td><%=resposta.getId()%></td>
      <td><%=resposta.getUsuario_id()%></td>
      <td><%=resposta.getPergunta_id()%></td>
      <td><%=resposta.getAlternativa()%></td>
      <td><%=FormataData.toString(resposta.getData_resposta())%></td>
      <td>
      	<a class="btn btn-warning" role="button" href="<%=request.getContextPath()%>/resposta/AlterarResposta.jsp?id=<%=resposta.getId()%>">Alterar</a>
      	<a class="btn btn-danger" role="button" href="<%=request.getContextPath()%>/resposta/ExcluirResposta.jsp?id=<%=resposta.getId()%>">Excluir</a>
      </td>
    </tr>
    
    <% } %>
    
  </tbody>
</table>
		</div>
	</body>
</html>