package com.ubosque.tiendavirtual;

import java.util.ArrayList;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.DAO.ProveedorDAO;
import com.ubosque.DAO.UsuarioDAO;
import com.ubosque.DTO.Proveedores;
import com.ubosque.DTO.Usuario;

@RestController
@ComponentScan(basePackages = { "com.ubosque.DAO" })
@RequestMapping("/proveedores")
public class ProveedorController {
	

	@RequestMapping("listar")
	public ArrayList<Proveedores> listaUsuario() {
		ProveedorDAO provedorDAO = new ProveedorDAO();
		return provedorDAO.listarProveedores();
	}
	
	@RequestMapping("listar/{nitproveedor}")
	public ArrayList<Proveedores> listaUsuarioUno(@PathVariable("nitproveedor") int nitproveedor) {
		ProveedorDAO provedorDAO = new ProveedorDAO();
		return provedorDAO.listarProveedor(nitproveedor);
	}

	@PostMapping("guardar")
	public void agregarUsuario(@RequestBody Proveedores proveedor) {
		ProveedorDAO provedorDAO = new ProveedorDAO();
		provedorDAO.crearProveedor(proveedor);
	}

	@DeleteMapping("eliminar/{nitproveedor}")
	public void eliminarUsuario(@PathVariable("nitproveedor") int nitproveedor) {
		ProveedorDAO provedorDAO = new ProveedorDAO();
		provedorDAO.deleteProveedor(nitproveedor);
	}

	@PutMapping("actualizar/{nitproveedor}")
	public void updatePerson(@PathVariable int nitproveedor, @RequestBody Proveedores proveedores) {
		ProveedorDAO provedorDAO = new ProveedorDAO();
		provedorDAO.updateProveedor(proveedores);
	}
}
