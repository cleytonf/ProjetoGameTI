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
	<!--"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
-->
	<!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
		integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="/GameTI/assets/css/loginStylo.css">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600&display=swap" rel="stylesheet">

	<link rel="sortcut icon" href="../icon-gameti.png" type="image/x-icon" />
</head>

<body>
	<%@ include file="Menu.jsp" %>

	
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					
					<h3>Cadastro</h3>
				
				</div>
				<div class="card-body">
					<form method="post" action="<%=request.getContextPath()%>/CadastrarUsuario.do">

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" id="nome" name="nome" class="form-control" placeholder="Usuário">

						</div>

						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input type="email" id="email" name="email" class="form-control" placeholder="Email">

						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" id="login" name="login" class="form-control" placeholder="Login">

						</div>

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" id="senha" name="senha" class="form-control" placeholder="Senha">
						</div>

						
						
						<div class="form-group">
							<input type="submit" value="Cadastrar" class="btn float-right login_btn">
						</div>
					</form>
			  	</div>
			<!--	<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Não possui uma conta?<a href="#">Cadastre-se</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Esqueceu sua Senha?</a>
					</div>
				</div> -->
			</div>
		</div>

	</div>

	<%@ include file="Rodape.jsp" %>

	</body>

</html>