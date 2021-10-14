$(document).ready(function(){
	console.log("JQuery funcionando");
	
	$("#formulario").submit(e => {
		e.preventDefault();
	 	
		$.ajax({
			type:"POST",
			async: false,
			data: JSON.stringify({usuario:$("#usuario").val(), password:$("#password").val()}),
			url:"http://localhost:8080/usuarios/auth",
			contentType: "application/json",
			success: function(response){
				console.log(response);
				if(response==1){
					alert("Igreso al sistema Admin");
				}else if(response != 0){
					alert("Ingreso sistema usuario con cedula ->"+response);
				}
				let cedula_usuario = response;
				localStorage.setItem('usuario', cedula_usuario);
				window.location="principal.jsp";
				
			}
			
		});
	});
	
});
