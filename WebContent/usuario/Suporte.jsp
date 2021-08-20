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

    <!--bootstrap
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">-->

	<!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
		integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
      
        <!--CCS-->

	<link rel="stylesheet" type="text/css" href="/GameTI/assets/css/suporte.css">
	
    <!--Fontes-->
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
					
					<h3>Fala Conosco</h3>

				</div>
				<div class="card-body">
					<form action="#" method="post">
						<div class="input-group form-group">
							
							<input type="text" class="form-control" placeholder="Nome Completo">
							
						</div>

						<div class="input-group form-group">
							
							<input type="email" class="form-control" placeholder="Email">
							
						</div>
						<div class="input-group form-group">
							
							<input type="text" class="form-control" placeholder="Assunto">
							
						</div>
						
						<div class="input-group form-group">
						<textarea name="Assunto" id="" cols="50" rows="7"></textarea>
							
						
						</div>
						<div class="form-group">
							<input type="submit" value="Enviar" class="btn float-right login_btn">
						</div>
						</div>
						
					
						
					</form>
				</div>
				
			</div>
		</div>
	</div>

	<%@ include file="Rodape.jsp" %>
	
</body>

</html>