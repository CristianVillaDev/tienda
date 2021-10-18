
$(document).ready(function(){
	
	console.log('Funcionando ventas');
	let contador = 1;

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
						<option data="${producto.codigoProducto}" value="${producto.codigoProducto}"> ${producto.codigoProducto} , ${producto.nombreProducto}</option>
					`
				});
				$('.listado').prepend(template);
				 template='';
	         }
	      });
	}
	
 	let calculo1 =0;
	let calculo2 =0;
	let calculo3 =0;
	let iva1=0;
	let iva2=0;
	let iva3=0;
	let calculoiva1 =0;
	let calculoiva2=0;
	let calculoiva3=0;
	
	let totalVenta =0;
	let totalIva=0;
	let total=0
	
	
	function actualizarValores(){
		$("#valorVenta").val(totalVenta);
		$("#totalIva").val(totalIva);
		$("#TotalFinal").val(total);
	}
	
	function calculos(){
		totalVenta = calculo1 + calculo2+ calculo3;
		console.log(totalVenta);
		totalIva = iva1+iva2+iva3;
		console.log(totalIva);
		total = calculoiva3 + calculoiva2 + calculoiva1;
	}
	
let	producto_id1 =0;
let producto_id2=0;
let producto_id3=0; 
	
	$("#option1").on("keyup",(response)=>{
		producto_id1 = $("#lista1 option:selected").val();
		$.ajax({
	        type: "GET",
	        url: "http://localhost:8080/productos/listar/"+producto_id1,  
	        success: function(data) {
				const productos = data;
				
				calculo1 = productos[0].precioCompra * $("#option1").val();
				iva1 = (calculo1 * productos[0].ivaCompra)/100;
				calculoiva1 = iva1+calculo1;
				$("#valor1").val(calculoiva1);
				
				calculos();
				actualizarValores();
	         }
	      });
	});
	
	$("#option2").on("keyup",(response)=>{
		producto_id2 = $("#lista2 option:selected").val();
		$.ajax({
	        type: "GET",
	        url: "http://localhost:8080/productos/listar/"+producto_id2,  
	        success: function(data) {
				const productos = data;
			
				calculo2 = productos[0].precioCompra * $("#option2").val();
				iva2 = (calculo2 * productos[0].ivaCompra)/100;
				calculoiva2 = iva2+calculo2;
				$("#valor2").val(calculoiva2);
			 
		
				console.log(calculoiva2);
				calculos();
				actualizarValores();
	         }
	      });
	});

	$("#option3").on("keyup",(response)=>{
		producto_id3 = $("#lista3 option:selected").val();
		$.ajax({
	        type: "GET",
	        url: "http://localhost:8080/productos/listar/"+producto_id3,  
	        success: function(data) {
				const productos = data;
		
				calculo3 = productos[0].precioCompra * $("#option3").val();
				iva3 = (calculo3 * productos[0].ivaCompra)/100;
				calculoiva3 = iva3+calculo3;
				$("#valor3").val(calculoiva3);
				
				calculos();
				actualizarValores();
	         }
	      });
	});
	
let id_venta = 0;

	$("#formulario").submit(e=>{
		e.preventDefault();
		
		$("#mensaje").html("Cargando ... ");
		
		var cedula = localStorage.getItem("usuario");
		console.log(cedula);
		
		if($("#cedula").val() == 0){
			alert("Campo de cedula vacio!");
			return;
		}
		
		$("#mensaje").html("Validando ... ");
		$("#mensaje").html("Ejecutando peticion AJAX ventas... ");
		$.ajax({
	            type: "POST",
	            url: "http://localhost:8080/ventas/guardar",
	            data: JSON.stringify({
					  cedulaCliente:$("#cedula").val(),
					  cedulaUsuario:cedula,
					  ivaVenta: totalIva,
					  totalVenta: total,
					  valorVenta: totalVenta}),
	           		  contentType: "application/json",
	            success: function (data) {
					console.log("Venta agregada");
	
	       		}
	    });	

		$("#mensaje").html("Cargando ... ");
		$("#mensaje").html("Ejecutando peticion AJAX ... ");
		setTimeout(function(){ obtenerIdventa(); }, 5000);
		$("#mensaje").html("Cargando ... ");
		$("#mensaje").html("Ejecutando peticion AJAX ... ");
		setTimeout(function(){ detalle(); }, 15000);
		$("#mensaje").html("Cargando ... ");
		$("#mensaje").html("Ejecutando peticion AJAX ... ");
		setTimeout(function(){ detalle2(); }, 20000);
		$("#mensaje").html("Cargando ... ");
		$("#mensaje").html("Ejecutando peticion AJAX ... ");
		setTimeout(function(){ detalle3(); }, 25000);
		
		$("#mensaje").html("Cargando ... ");
		
		
	});
	
	function obtenerIdventa(){
		$.ajax({
	        type: "GET",
	        url: "http://localhost:8080/ventas/codigo",  
	        success: function(data) {
				id_venta = data;
				console.log("id venta agregada "+id_venta); 
				$("#codigo_consecutivo").val(id_venta);
	         }
	      });
	}
	
	function detalle(){
		$.ajax({
	            type: "POST",
	            url: "http://localhost:8080/detalleventas/guardar",
	            data: JSON.stringify({
						  cantidadProducto: $("#option1").val(),
						  codigoProducto: producto_id1 , 
						  codigoVenta: id_venta,
						  valorTotal: calculoiva1,
						  valorVenta :calculo1,
					  	  valorIva: iva1
						}),
	           	contentType: "application/json",
	            success: function (data) {
					$("#mensaje").html("Completado detalles 1... ");
	       		}
	    });
	}
	
	function detalle2(){
		$.ajax({
	            type: "POST",
	            url: "http://localhost:8080/detalleventas/guardar",
	            data: JSON.stringify({
						  cantidadProducto: $("#option2").val(),
						  codigoProducto: producto_id2 , 
						  codigoVenta: id_venta,
						  valorTotal: calculoiva2,
						  valorVenta :calculo2,
					  	   valorIva: iva2
						}),
	           		  contentType: "application/json",
	            success: function (data) {
					$("#mensaje").html("Completado detalles 2... ");
	       		}
	    });
	}
	
	function detalle3(){
		$.ajax({
	            type: "POST",
	            url: "http://localhost:8080/detalleventas/guardar",
	            data: JSON.stringify({
						  cantidadProducto: $("#option3").val(),
						  codigoProducto: producto_id3 , 
						  codigoVenta: id_venta,
						  valorTotal: calculoiva3,
						  valorVenta :calculo3,
					  	  valorIva: iva3
						}),
	           		  contentType: "application/json",
	            success: function (data) {
					$("#mensaje").html("Completado detalles 3... ");
		
					$("#mensaje").html("Completado detalles... ");
					
					$("#mensaje").html("Completado con exito proceso ventas. ");
		
	       		}
	    });
	}
	
	$("#formulario_cedula").submit(e=>{
		e.preventDefault();
		cedula = $("#cedula").val();
		$.ajax({
	            type: "GET",
	            url: "http://localhost:8080/clientes/listar/"+cedula,
	            contentType: "application/json",
	            success: function (data) {
					if(Object.keys(data).length===0){
						alert("Cliente no encontrado");
						return;
					}
					$("#cedula_cliente").val(data[0].nombreCliente);
	       		}
	    });
	});
	
	$("#lista1").change(function(){
		$("#option1").val("");
		$("#valor1").val("");
	});
	$("#lista2").change(function(){
		$("#option2").val("");
		$("#valor2").val("");
	});
	$("#lista3").change(function(){
		$("#option3").val("");
		$("#valor3").val("");
	});
	
});