
$(document).ready(function(){
	console.log('Funcionando');
	listado();
	let flag = false;
	var btnCancelar = $("#cancelarOP");
	btnCancelar.css("display","none");
		
	$("#formulario").submit(e =>{
		e.preventDefault();
		
		const datos ={
			cedulaUsuario: $("#cedula").val(),
		 	emailUsuario: $("#email").val(),
		  	nombreUsuario: $("#nombre").val(),
		 	password: $("#clave").val(),
		 	usuario: $("#usuario").val()
		};
		
		const cedula =  $("#cedula").val();
		
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];

		let url = '';
		let type= '';
		let mensaje ='';
		
		if(flag){
			url = baseUrl+"/usuarios/actualizar/"+cedula;
			type= "PUT";
			mensaje="Datos del Usuario Actualizados";
			
		}else{
			url = baseUrl+"/usuarios/guardar";
			type= "POST";
			mensaje="Usuario Creado";
		}

		$.ajax({
	            type: type,
	            url: url,
	            async: false,
	            data: JSON.stringify({ cedulaUsuario: $("#cedula").val(), emailUsuario: $("#email").val(),nombreUsuario:$("#nombre").val(),password: $("#clave").val(), usuario: $("#usuario").val()}),
	            contentType: "application/json",
	            complete: function (data) {

				 	listado();
				
					limpiadoCampos();	
					
					flag = false;
					
					alert(mensaje);
					
					var btnCancelar = $("#cancelarOP");
					btnCancelar.css("display","none");
					
					$("#cedula").removeAttr('disabled');
	        }
	    });
	});

	function limpiadoCampos(){
			  $("#cedula").val("");
		 	  $("#email").val("");
		  	  $("#nombre").val("");
		 	  $("#clave").val("");
		 	  $("#usuario").val("");
	}
	
	function listado(){
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
	   $.ajax({
	        type: "GET",
	        url: baseUrl+"/usuarios/listar",  
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

	$(document).on('click','.borrar',(response)=> {
		const nit_p = $(this)[0].activeElement;
		const nitproveedor = $(nit_p).attr('id');
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
 		$.ajax({
			type:"DELETE",
			url:baseUrl+"/usuarios/eliminar/"+cedula,
			success: function(response){
				listado();
				alert("Datos del Usuario Borrados");
			}
		});
	});
	
	$(document).on('click','.modificar',(response)=> {
			const cedula = $(this)[0].activeElement;
			const cedula_usuario = $(cedula).attr('id');
			
			var btnCancelar = $("#cancelarOP");
			btnCancelar.css("display","block");
			
			$("#cedula").attr('disabled',true);
			
			var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
	 	
		 $.ajax({
			type:"GET",
			url: baseUrl+"/usuarios/listar/"+cedula_usuario,
			success: function(response){
				console.log(response);
				const usuario = response[0];
				console.log(usuario);
				$("#cedula").val(usuario.cedulaUsuario);
			 	$("#email").val(usuario.emailUsuario);
			  	$("#nombre").val(usuario.nombreUsuario);
			 	$("#clave").val(usuario.password);
			 	$("#usuario").val(usuario.usuario);
				flag = true;	
			}
		});
		
	});
	
	$(document).on('click','.cancelar',(response)=> {	
		limpiadoCampos();
		
		flag = false;
		
		var btnCancelar = $("#cancelarOP");
		btnCancelar.css("display","none");
		$("#cedula").removeAttr('disabled');
	});
	
	
	$(document).on('click','.ver',(response)=> {
			const cedula = $(this)[0].activeElement;
			const cedula_usuario = $(cedula).attr('id');
			 	var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
		 $.ajax({
			type:"GET",
			url: baseUrl+"/usuarios/listar/"+cedula_usuario,
			success: function(response){
				const usuario = response[0];

				$("#cedula_modal").html(usuario.cedulaUsuario);
			 	$("#email_modal").html(usuario.emailUsuario);
			  	$("#nombre_modal").html(usuario.nombreUsuario);
			 	$("#clave_modal").html(usuario.password);
			 	$("#usuario_modal").html(usuario.usuario);
				
			}
		});
		
	});
	
	$("#cerrar").on("click",(response)=>{
		limpiadoCamposModal();
	});
	
	function limpiadoCamposModal(){
		       $("#cedula_modal").html("");
			 	$("#email_modal").html("");
			  	$("#nombre_modal").html("");
			 	$("#clave_modal").html("");
			 	$("#usuario_modal").html("");
	}
	
});