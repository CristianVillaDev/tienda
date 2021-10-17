package com.ubosque.tiendavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ubosque.DAO.Connection;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ubosque.tiendavirtual"})
public class TiendavirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendavirtualApplication.class, args);
		Connection connection = new Connection(); 
		connection.getConnection();
	}
}
