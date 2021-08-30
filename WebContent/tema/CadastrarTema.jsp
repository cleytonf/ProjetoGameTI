<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
					
					<h3>Cadastrar Tema</h3>
				
				</div>
				<div class="card-body">
					<form method="post" action="<%=request.getContextPath()%>/CadastrarTema.do">

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" id="nome" name="nome" class="form-control" placeholder="Nome do Tema">

						</div>

						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa-solid fa-envelope"></i></span>
							</div>
							<input type="text" id="descricao" name="descricao" class="form-control" placeholder="Descrição do Tema">

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