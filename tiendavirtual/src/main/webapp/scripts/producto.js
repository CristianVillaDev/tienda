
$(document).ready(function(){
	console.log('Funcionando p');
	
	$("#formulario").submit(e =>{
		e.preventDefault();
		
		var form_data = new FormData();
		var file_data = $("#file").prop("files")[0];
	
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
			
				
		form_data.append("file", file_data);
		$.ajax({
	            type: "POST",
	            url: baseUrl+"/productos/guardar",
	            dataType: "html",
                data: form_data,
				contentType: false, 
              	processData: false, 
	            complete: function (data) {
					console.log(data);
					$("#mensaje").html("Productos cargados.");
	       		}
	    });
	});
	
	
	function consulta(){
		
		var getUrl = window.location;
		var baseUrl = getUrl.protocol + "//"+getUrl.host+"/"+getUrl.pathname.split('/')[1];
		
		$.ajax({
	            type: "POST",
	            url: baseUrl+"/productos/listar/cantidad",
	            dataType: "html",
                data: form_data,
				contentType: false, //importante enviar este parametro en false
              	processData: false, //importante enviar este parametro en false
	            complete: function (data) {
					console.log(data);
	       		}
	    });
	}
});