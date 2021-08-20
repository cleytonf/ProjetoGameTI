<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>GameTi</title>
  
  	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.5.3-dist/css/bootstrap.min.css">
  
 <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"> -->
    
    <link rel="stylesheet" href="/GameTI/assets/css/ranking.css">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600&display=swap" rel="stylesheet">

    <link rel="sortcut icon" href="../icon-gameti.png" type="image/x-icon" />

</head>

<body>
	<%@ include file="Menu.jsp" %>
  	  <main>

    <div class="texto">

      <h1>VEJA AQUI SUA PONTUAÇÃO !</h1>
     <h4> Mostre para todos quem conhece mais 
      sobre o <br> mundo da programação.</h4>
<br>
      <label for="cars"> OS MELHORES COLOCADOS DO QUIZ:</label>
      <br>
<br>
<select id="colocacao">
  <option value="" selected></option>
  <option value="numero01">Alan - 1º Lugar</option>
  <option value="numero02">Carla - 2º Lugar</option>
  <option value="numero03">Beatriz - 3º Lugar</option>
  <option value="numero03">Lucas - 4º Lugar</option>
</select>
  </div>

  
  </main>


	<%@ include file="Rodape.jsp" %>
	
  
</body>

</html>