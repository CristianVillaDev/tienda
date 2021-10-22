package com.ubosque.DAO;

import java.sql.SQLException;
import java.sql.DriverManager;

public class Connection {
	
	String database="tiendagrupo60_2"; 
	String user="root";
	String password= "admin123"; 
	String hostname= "tiendagrupo60.c47knbsonjdi.us-east-2.rds.amazonaws.com";
	String port= "3306";
	String url= "jdbc:mariadb://" + hostname + ":" + port + "/" + database + "?user=" + user + "&password=" + password;
 
	java.sql.Connection connection = null;
	
	public java.sql.Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

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
