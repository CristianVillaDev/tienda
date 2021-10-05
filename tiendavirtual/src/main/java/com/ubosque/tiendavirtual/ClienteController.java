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

import com.ubosque.DAO.ClienteDAO;
import com.ubosque.DTO.Clientes;

@RestController
@ComponentScan(basePackages = { "com.ubosque.DAO" })
@RequestMapping("/clientes")
public class ClienteController {

	@RequestMapping("listar")
	public ArrayList<Clientes> listarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.listarClientes();
	}

	@RequestMapping("listar/{cedula_cliente}")
	public ArrayList<Clientes> listarCliente(@PathVariable("cedula_cliente") int cedula_cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.listarCliente(cedula_cliente);
	}

	@PostMapping("guardar")
	public void saveCliente(@RequestBody Clientes cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.crearCliente(cliente);
	}

	
	@PutMapping("actualizar/{cedula_cliente}")
	public void updateCliente(@PathVariable("cedula_cliente") int cedula_cliente, @RequestBody Clientes cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.updateClientes(cliente);
	}

	@DeleteMapping("eliminar/{cedula_cliente}")
	public void deleteCliente(@PathVariable("cedula_cliente") int cedula_cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.deleteCliente(cedula_cliente);
	}
	
}
