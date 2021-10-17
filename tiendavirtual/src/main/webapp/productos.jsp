<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Generica</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<h2>TIENDA GENERICA</h2>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Grupo 60</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor03"
				aria-controls="navbarColor03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarColor03">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link " href="#">Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="clientes.jsp">Clientes</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="proveedores.jsp">Proveedores</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Productos
							<span class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="ventas.jsp">Ventas</a></li>
					<li class="nav-item"><a class="nav-link" href="reportes.jsp">Reportes</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<p id="error"></p>
		<div class="mx-auto mt-5" style="width: 200px;">
			<form id="formulario">
				<input class="mx-auto" id="file" type="file" accept=".csv" required>
				<button type="submit">Cargar</button>
			</form>
		</div>
	</div>
	<div class="container">
		<h3 class="mx-auto" id="mensaje"></h3>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
		integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
		crossorigin="anonymous"></script>
	<script src="scripts/producto.js"></script>
</body>
</html>