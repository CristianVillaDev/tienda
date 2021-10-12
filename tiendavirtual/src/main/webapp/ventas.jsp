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
					<li class="nav-item"><a class="nav-link " href="usuarios.jsp">Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="clientes.jsp">Clientes</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="proveedores.jsp">Proveedores</a></li>
					<li class="nav-item"><a class="nav-link" href="productos.jsp">Productos</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Ventas
							<span class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="reportes.sjp">Reportes</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid " style="background: #C6BDBB;">
		<div class="row p-4">
			<div class="col-md-6 p-3  ">

				<form id="formulario_cedula_cliente">
					<div class="row p-1">
						<div class="col-md-2">
							<h6 class="mt-3 ml-2">Cedula</h6>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<input type="text" class="form-control" id="cedula"
									placeholder="Ingresar cedula" required>
							</div>
						</div>
						<div class="col-md-5">
							<button type="submit" class="btn btn-primary">Consultar</button>
						</div>
					</div>
				</form>

			</div>

			<div class="col-md-3 p-3 ">
				<div class="row">
					<div class="col">
						<h6 class="mt-3">Cliente</h6>
					</div>
					<div class="col">
						<input disabled type="text" id="cedula_cliente"
							class="form-control">
					</div>
				</div>
			</div>

			<div class="col-md-3 p-3">
				<div class="row">
					<div class="col">
						<h6 class="mt-3">Consecutivo</h6>
					</div>
					<div class="col">
						<input disabled type="text" id="codigo_consecutivo"
							class="form-control">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid bg-info">
		<div class="bg-danger p-4">
			<table class="mx-auto">
				<thead>
					<tr>
						<td>Codigo producto</td>
						<td>Cantidad</td>
						<td>Valor total</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><select id="listado"
							class="listado form-select form-select-sm">
								<option>Seleccione producto</option>
						</select></td>

						<td><input type="number" class="form-control form-control-sm"
							max="2"></td>

						<td><input type="number" class="form-control form-control-sm" disabled></td>
					</tr>
					<tr>
						<td><select id="listado"
							class="listado form-select form-select-sm">
								<option>Seleccione producto</option>
						</select></td>

						<td><input type="number" class="form-control form-control-sm"
							max="2"></td>

						<td><input type="number" class="form-control form-control-sm" disabled></td>
					</tr>
					<tr>
						<td><select id="listado"
							class="listado form-select form-select-sm">
								<option value="0">Seleccione producto</option>
						</select></td>

						<td><input type="number" class="form-control form-control-sm"
							max="2"></td>

						<td><input type="number" class="form-control form-control-sm"disabled></td>
					</tr>
					
				</tbody>
			</table>
		
						<button>Agregar otro producto</button>
				
		</div>
	
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
			integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			crossorigin="anonymous"></script>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
			integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
			crossorigin="anonymous"></script>
		<script src="scripts/ventas.js"></script>
</body>
</html>