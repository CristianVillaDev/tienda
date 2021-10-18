<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Tienda Generica</title>
</head>
<body>

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
					<li class="nav-item"><a class="nav-link active" href="usuarios.jsp">Usuarios
							<span class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="clientes.jsp">Clientes</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="proveedores.jsp">Proveedores</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="productos.jsp">Productos</a></li>
					<li class="nav-item"><a class="nav-link" href="ventas.jsp">Ventas</a></li>
					<li class="nav-item"><a class="nav-link" href="reportes.jsp">Reportes</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container-fluid">
		<div class="mx-auto">
				<a href="listadoUsuarios.jsp" class="btn btn-primary">Listado de usuarios</a>
				<a href="listadoClientes.jsp" class="btn btn-primary">Listado de clientes</a>
				<a href="ventasPorCliente.jsp" class="btn btn-primary">Ventas por cliente</a>
		</div>
	</div>

	<div class="container-fluid row pl-0">
		<div class="col-md-9  p-2">
			<div class="table-responsive ">
				<table
					class="table table-dark table-hover table-sm table-bordered  ">
					<thead>
						<tr>
							<td class="text-lowercase" style="font-size: 16px;">Cedula</td>
							<td class="text-lowercase" style="font-size: 16px;">Nombre</td>
							<td class="text-lowercase" style="font-size: 16px;">Email</td>
							<td class="text-lowercase" style="font-size: 16px;">Usuario</td>
							<td class="text-lowercase" style="font-size: 16px;">Contraseña</td>
						</tr>
					</thead>
					<tbody id="cuerpoTabla">

					</tbody>
				</table>


			</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
		integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
		crossorigin="anonymous"></script>
		
	<script src="scripts/reporteUsuarios.js"></script>
</body>
</html>