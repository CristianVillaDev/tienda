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
					<li class="nav-item"><a class="nav-link" href="productos.jsp">Productos</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Ventas
							<span class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Reportes</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid row bg-info ">
		<div class="row bg-danger p-4">
			<div class="col-md-4 p-3 bg-info">

				<form id="formulario_cedula_cliente" class="bg-success">
					<div class="row">
						<div class="col-sm-2">
							<h5 class="mt-3">Cedula</h5>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<input type="text" class="form-control" id="cedula"
									placeholder="Ingresar cedula" required>
							</div>
						</div>
						<div class="col-sm-4">
							<button type="submit" class="btn btn-primary">Consultar</button>
						</div>
					</div>
				</form>

			</div>

			<div class="col-md-4 p-3 bg-success">

				<div class="row">
					<div class="col">
						<h5 class="mt-3">Cedula</h5>
					</div>
					<div class="col">
						<input disabled type="text" id="cedula_cliente"
							class="form-control">
					</div>
				</div>
			</div>

			<div class="col-md-4 p-3 bg-info">
				<div class="row">
					<div class="col">
						<h5 class="mt-3">Consecutivo</h5>
					</div>
					<div class="col">
						<input disabled type="text" id="codigo_consecutivo"
							class="form-control">
					</div>
				</div>
			</div>
		</div>

		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
			integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			crossorigin="anonymous"></script>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
			integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
			crossorigin="anonymous"></script>
		<script src="scripts/usuarios.js"></script>
</body>
</html>