package com.ubosque.tiendavirtual;

import java.util.ArrayList;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.DAO.VentaDAO;
import com.ubosque.DTO.Ventas;

@RestController
@ComponentScan(basePackages = { "com.ubosque.DAO" })
@RequestMapping("/ventas")
public class VentaController {

	@PostMapping("guardar")
	public void saveVenta(@RequestBody Ventas venta) {
		VentaDAO ventaDAO = new VentaDAO();
		ventaDAO.addVenta(venta);
	}
	
	@PutMapping("actualizar/{codigo_venta}")
	public void updateVenta (@RequestBody Ventas venta, @PathVariable("codigo_venta") int codigo_venta) {
		VentaDAO ventaDAO = new VentaDAO();
		ventaDAO.updateVenta(venta,codigo_venta);
	}
	
	@DeleteMapping("eliminar/{codigo_venta}")
	public void deleteVenta(@PathVariable("codigo_venta") int codigo_venta) {
		VentaDAO ventaDAO = new VentaDAO();
		ventaDAO.deleteVentas(codigo_venta);
	}
	
	@RequestMapping("listar")
	public ArrayList<Ventas> showVentas(){
		VentaDAO ventaDAO = new VentaDAO();
		return ventaDAO.listarVentas();
	}
	
	@RequestMapping("codigo")
	public int obtenerId(){
		VentaDAO ventaDAO = new VentaDAO();
		return ventaDAO.listarVentaID();
	}
	
	@RequestMapping("listar/{codigo_venta}")
	public ArrayList<Ventas> showVentas(@PathVariable("codigo_venta") int codigo_venta){
		VentaDAO ventaDAO = new VentaDAO();
		return ventaDAO.listarVenta(codigo_venta);
	}
}
