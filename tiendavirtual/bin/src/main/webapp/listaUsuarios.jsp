<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Usuarios </title>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">

</head>
<body>

	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>Cedula</th>
				<th>Email</th>
				<th>Nombre</th>
				<th>Contraseña</th>
				<th>Usuario</th>
			</tr>
		</thead>
		<tbody id="cuerpoTabla">

		</tbody>
	</table>



	<script src="scripts/table.js"></script>
	<script src="/lib/jquery.min.js"></script>
<script src="/lib/jquery.plugin.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js">
		
	</script>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>