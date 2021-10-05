package com.ubosque.DAO;

import java.sql.SQLException;
import java.sql.DriverManager;

public class Connection {
	String database="tienda";
	String user="root";
	String password="19731973";
	//String url ="jdbc:mysql://tiendagrupo60.c47knbsonjdi.us-east-2.rds.amazonaws.com:3306/tiendagrupo60";
	String url= "jdbc:mysql://localhost/"+database;
	
	java.sql.Connection connection = null;
	
	public java.sql.Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
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
