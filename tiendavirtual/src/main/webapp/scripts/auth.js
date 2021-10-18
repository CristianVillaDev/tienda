$(document).ready(function(){
	console.log("JQuery funcionando");
	
	$("#formulario").submit(e => {
		e.preventDefault();
	 	var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
		console.log(baseUrl);
		$.ajax({
			type:"POST",
			async: false,
			data: JSON.stringify({usuario:$("#usuario").val(), password:$("#password").val()}),
			url: baseUrl+"/usuarios/auth",
			contentType: "application/json",
			success: function(response){
				console.log(response);
				if(response==1){
					alert("Igreso al sistema Admin");
				}else if(response != 0){
					alert("Ingreso sistema usuario con cedula ->"+response);
				}
				if(response != 0){
					let cedula_usuario = response;
					localStorage.setItem('usuario', cedula_usuario);
					window.location="principal.jsp";
				}else{
					alert("Usuario o contrseña incorrectos!");
				}
			}
		});
	});
});
