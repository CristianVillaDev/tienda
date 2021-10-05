<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Usuarios</title>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>


	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<td class="text-lowercase">Cedula</td>
				<td class="text-lowercase">Email</td>
				<td class="text-lowercase">Nombre</td>
				<td class="text-lowercase">Contraseña</td>
				<td class="text-lowercase">Usuario</td>
				<td class="text-lowercase">Modificar</td>
				<td class="text-lowercase">Eliminar</td>
			</tr>
		</thead>
		<tbody id="cuerpoTabla">

		</tbody>
	</table>

	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
	<script src="scripts/table.js"></script>

</body>
</html>