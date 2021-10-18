package com.ubosque.DAO;

import java.sql.SQLException;
import java.sql.DriverManager;

public class Connection {
	
	//String database="tienda";
	//String user="root";
	//String password="19731973";
	//String url= "jdbc:mysql://localhost/"+database;
	
	String database="tiendagrupo60"; 
	String user="root";
	String password= "admin123"; 
	String hostname= "tiendagrupo60.c47knbsonjdi.us-east-2.rds.amazonaws.com";
	String port= "3306";
	String url= "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?user=" + user + "&password=" + password;
 
	java.sql.Connection connection = null;
	
	public java.sql.Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//System.out.print(url);
			//connection=DriverManager.getConnection(url,user,password);
			connection=DriverManager.getConnection(url);
			if(connection!=null) {
				System.out.println("Conexi�n exitosa a la base de datos");
			}
		
		}catch(SQLException e){
			e.getMessage();
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}
		return connection;
	}
}
