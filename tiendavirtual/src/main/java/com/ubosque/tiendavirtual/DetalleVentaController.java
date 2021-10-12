package com.ubosque.tiendavirtual;

import java.util.ArrayList;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.DAO.DetalleVentaDAO;
import com.ubosque.DTO.DetallesVentas;

@RestController
@ComponentScan(basePackages = { "com.ubosque.DAO" })
@RequestMapping("/detalleventas")
public class DetalleVentaController {

	@RequestMapping("listar")
	public ArrayList<DetallesVentas> listarDetallesVentas(){
		DetalleVentaDAO detallesDAO = new DetalleVentaDAO();
		return detallesDAO.listarDetalleVentas();
	}
	
	@PostMapping("guardar")
	public void addDetalleVenta(@RequestBody DetallesVentas ventas) {
		DetalleVentaDAO detallesDAO = new DetalleVentaDAO();
		detallesDAO.addDetalleVenta(ventas);
	}

}
