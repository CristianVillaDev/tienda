
$(document).ready(function(){
	console.log('Funcionando p');
	
	$("#formulario").submit(e =>{
		e.preventDefault();
		
		var form_data = new FormData();
		var file_data = $("#file").prop("files")[0];

		form_data.append("file", file_data);
		$.ajax({
	            type: "POST",
	            url: "http://localhost:8080/productos/guardar",
	            dataType: "html",
                data: form_data,
				contentType: false, //importante enviar este parametro en false
              	processData: false, //importante enviar este parametro en false
	            complete: function (data) {
					console.log(data);
	       		}
	    });
	});
	
	
	function consulta(){
		$.ajax({
	            type: "POST",
	            url: "http://localhost:8080/productos/listar/cantidad",
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