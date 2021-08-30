<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.List"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import="br.edu.ifs.modelo.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>GameTI</title>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.5.3-dist/css/bootstrap.min.css">
	
</head>

<body>
	<%@ include file="../MenuLogado.jsp" %>

	
	<div class="container">
		<div >
			<div class="card">
				<div class="card-header">
					
					<h3>Cadastrar Pergunta</h3>
				
				</div>
				<div class="card-body">
					<form method="post" action="<%=request.getContextPath()%>/CadastrarPergunta.do">

						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							

							<select id="tema_id" name="tema_id" class="form-control"> 
									<%
									
									IFabricaConexoes fabrica = new FabricaConexoesPostegres();
						  			ITemadao temadao = new TemadaoPostegres(fabrica.obterConexao());
						  			
						  			List<Tema> listarTemas = temadao.listar();
						  			
						  			for (Tema tema : listarTemas){
						  				
						  		%>
						  
						    <option value="<%=tema.getId()%>"><%=tema.getNome()%></option>
						      
						    
						    <% } %>
									
									
							 </select>

						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							<input type="text" id="descricao" name="descricao" class="form-control" placeholder="Descrição">
						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							<input type="text" id="alternativa_1" name="alternativa_1" class="form-control" placeholder="Alternativa 1">
						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							<input type="text" id="alternativa_2" name="alternativa_2" class="form-control" placeholder="Alternativa 2">
						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							<input type="text" id="alternativa_3" name="alternativa_3" class="form-control" placeholder="Alternativa 3">
						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							<input type="text" id="alternativa_4" name="alternativa_4" class="form-control" placeholder="Alternativa 4">
						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							<input type="text" id="gabarito" name="gabarito" class="form-control" placeholder="Gabarito">
						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							 <select id="status" name="status" >

						  	<option value="1">Ativo</option>
       						 <option value="2">Inativo</option>
						</select>
						</div>

						<div class="form-group">
							<input type="submit" value="Cadastrar" class="btn float-right login_btn">
						</div>
					</form>
			  	</div>
			
			</div>
		</div>

	</div>

	<%@ include file="../Rodape.jsp" %>

	</body>

</html>