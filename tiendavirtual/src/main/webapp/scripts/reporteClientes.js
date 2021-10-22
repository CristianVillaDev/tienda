
$(document).ready(function(){

	listado();
	
	function listado(){
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
	   $.ajax({
	        type: "GET",
	        url: baseUrl+"/clientes/listar",  
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

	
