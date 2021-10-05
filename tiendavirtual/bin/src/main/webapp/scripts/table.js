


var saveme= $.ajax({
	
	type: "GET",
	url:"https://localhost:8090/listarUsuarios",
	
	success : function(data){
		$.each(data,function(i,item){
		lista = document.getElementById("cuerpoTabla");
		
		var tr = document.createElement("tr");
		
		var columna1 = document.createElement("th");
		columna1.innerHTML = item.cedulaUsuario;
		
		var columna2 = document.createElement("th");
		columna2.innerHTML = item.emailUsuario;
		
		var columna3 = document.createElement("th");
		columna3.innerHTML = item.nombreUsuario;
		
		var columna4 = document.createElement("th");
		columna4.innerHTML = item.password;
		
		var columna5 = document.createElement("th");
		columna5.innerHTML = item.usuario;	
		
			lista.appendChild(tr);
			tr.appendChild(columna1);
			tr.appendChild(columna2);
			tr.appendChild(columna3);
			tr.appendChild(columna4);
			tr.appendChild(columna5);
		});
	}
	
});