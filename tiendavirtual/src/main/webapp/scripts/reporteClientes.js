
$(document).ready(function(){

	listado();
	
	function listado(){
	   $.ajax({
	        type: "GET",
	        url: "http://localhost:8080/clientes/listar",  
	        success: function(data) {
				const clientes = data;
				let template='';
				clientes.forEach(cliente => {
					template += `
						<tr>
							<td style="font-size: 13px">${cliente.cedulaCliente}</td>
							<td style="font-size: 13px">${cliente.nombreCliente}</td>
							<td style="font-size: 13px">${cliente.emailCliente}</td>
							<td style="font-size: 13px">${cliente.direccionCliente}</td>
							<td style="font-size: 13px">${cliente.telefonoCliente}</td>
						</tr>
					`
				});
				$('#cuerpoTabla').html(template);
	         }
	      });
	}
});

	
