
$(document).ready(function(){
	
	console.log('Funcionando ventas');
	
	listado();
	
	function listado(){	
	
	   $.ajax({
	        type: "GET",
	        url: "http://localhost:8080/productos/listar",  
	        success: function(data) {
				const productos = data;
				let template='';
				console.log(productos);
				productos.forEach(producto => {
					template += `
						<option value="${producto.codigoProducto}"> ${producto.codigoProducto} , ${producto.nombreProducto}</option>
					`
				});
				$('.listado').prepend(template);
	         }
	      });
	}
 
	
	
	
	

	
});