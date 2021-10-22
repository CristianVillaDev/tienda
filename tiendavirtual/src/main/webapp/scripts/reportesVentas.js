
$(document).ready(function(){
	
	var cedula = 0;
	
	$("#formulario").submit(e=>{
		e.preventDefault();
		console.log("click");
		cedula = $("#cedula").val();
		console.log(cedula);
		
		listado();
	});
	
	var contador = 0;
	function listado(){
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
	   $.ajax({
	        type: "GET",
	        url: baseUrl+"/ventas/reporte/"+cedula,  
	        success: function(data) {
				const reportes = data;
				console.log(data);
				let template='';
				reportes.forEach(reporte => {
					template += `
						<tr>
							<td style="font-size: 13px">${reporte.cedulaCliente}</td>
							<td style="font-size: 13px">${reporte.nombreCliente}</td>
							<td style="font-size: 13px">${reporte.totalVenta}</td>
						</tr>
					`
					contador = contador + reporte.totalVenta;
				});
				$('#cuerpoTabla').html(template);
	         }
	      });
		setTimeout(function(){$("#venta").html(contador);},5000);
	}
});