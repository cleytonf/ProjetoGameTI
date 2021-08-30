<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.html"><img src="<%=request.getContextPath()%>/assets/logo (1).png" alt="logo" id="logo"></a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/tema/Tema.jsp">Temas</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="<%=request.getContextPath()%>/Ranking.jsp">Ranking</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="<%=request.getContextPath()%>/Sobre.jsp">Sobre</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="<%=request.getContextPath()%>/Suporte.jsp">Suporte</a>
						</li>
					</ul>
					<div class="text-end">
						 <a href="<%=request.getContextPath()%>/CadastrarUsuario.jsp"><button type="button" class="btn btn-success">CADASTRE-SE</button></a>
					<!--  	<button type="button" class="btn btn-light text-dark me-2">Login</button> -->
						 <a href="<%=request.getContextPath()%>/autenticacao/Login.jsp"><button type="button" class="btn btn-success">Login</button></a>
					</div>
				</div>
			</div>

		</nav>

	</header>
