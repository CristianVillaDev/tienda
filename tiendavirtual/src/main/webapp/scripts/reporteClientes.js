
$(document).ready(function(){

	listado();
	
	function listado(){
	   $.ajax({
	        type: "GET",
	        url: "http://localhost:8080/usuarios/listar",  
	        success: function(data) {
				const usuarios = data;
				let template='';
				usuarios.forEach(usuario => {
					template += `
						<tr>
							<td style="font-size: 13px">${usuario.cedulaUsuario}</td>
							<td style="font-size: 13px">${usuario.emailUsuario}</td>
							<td style="font-size: 13px">${usuario.nombreUsuario}</td>
							<td style="font-size: 13px">${usuario.usuario}</td>
							<td style="font-size: 13px" ><button id="${usuario.cedulaUsuario}"   type="button" class="btn btn-info ver p-1" data-bs-toggle="modal" data-bs-target="#exampleModal">Ver</button></td>
							<td style="font-size: 13px" ><button id="${usuario.cedulaUsuario}"   type="button" class="btn btn-info modificar p-1">Modificar</button></td>
							<td style="font-size: 13px" ><button id="${usuario.cedulaUsuario}"   type="button" class="btn btn-danger borrar p-1" >Eliminar</button></td>
						</tr>
					`
				});
				$('#cuerpoTabla').html(template);
	         }
	      });
	}
});

	
