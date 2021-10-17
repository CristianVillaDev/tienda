package com.ubosque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import com.ubosque.DTO.Clientes;

public class ClienteDAO {

	public ArrayList<Clientes> listarClientes() {
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		Connection connection = new Connection();
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("Select * from clientes");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Clientes cliente = new Clientes();
				cliente.setCedulaCliente(result.getInt("cedula_cliente"));
				cliente.setDireccionCliente(result.getString("direccion_cliente"));
				cliente.setEmailCliente(result.getString("email_cliente"));
				cliente.setNombreCliente(result.getString("nombre_cliente"));
				cliente.setTelefonoCliente(result.getString("telefono_cliente"));

				clientes.add(cliente);
			}

			result.close();
			statement.close();
			connection.connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return clientes;
	}

	public void crearCliente(Clientes cliente) {
		Connection connection = new Connection();
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(
					"insert into clientes (cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente) values (?,?,?,?,?)");
			statement.setInt(1, cliente.getCedulaCliente());
			statement.setString(2, cliente.getDireccionCliente());
			statement.setString(3, cliente.getEmailCliente());
			statement.setString(4, cliente.getNombreCliente());
			statement.setString(5, cliente.getTelefonoCliente());
			int result = statement.executeUpdate();

			if (result == 1) {
				System.out.print("Usuario agregado");
			} else {
				System.out.print("Ha ocurrido un error");
			}

			connection.connection.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteCliente(int cedula_cliente) {
		Connection connection = new Connection();

		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("delete from clientes where cedula_cliente=?");
			statement.setInt(1, cedula_cliente);
			int result = statement.executeUpdate();

			if (result == 1) {
				System.out.print("Usuario Eliminado");
			} else {
				System.out.print("Ha ocurrido un error");
			}
			connection.connection.close();
			statement.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateClientes(Clientes cliente) {
		Connection connection = new Connection();

		try {
			String query = "select * from clientes where cedula_cliente = ? ";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, cliente.getCedulaCliente());
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				statement = connection.getConnection().prepareStatement(
						"update clientes set direccion_cliente=? ,email_cliente=?,nombre_cliente=?,telefono_cliente=? where cedula_cliente=?");
				statement.setString(1, cliente.getDireccionCliente());
				statement.setString(2, cliente.getEmailCliente());
				statement.setString(3, cliente.getNombreCliente());
				statement.setString(4, cliente.getTelefonoCliente());
				statement.setInt(5, cliente.getCedulaCliente());

				int result2 = statement.executeUpdate();

				if (result2 == 1) {
					System.out.print("Usuario actualizado");
				}

				connection.connection.close();
				result.close();
				statement.close();
			} else {
				System.out.print("Ha ocurrido un error");
			}
			result.close();
			connection.connection.close();
			statement.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Clientes> listarCliente(int cedula_cliente) {
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		Connection connection = new Connection();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("select * from clientes where cedula_cliente=?");
			statement.setInt(1, cedula_cliente);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Clientes cliente = new Clientes();
				cliente.setCedulaCliente(result.getInt("cedula_cliente"));
				cliente.setDireccionCliente(result.getString("direccion_cliente"));
				cliente.setEmailCliente(result.getString("email_cliente"));
				cliente.setNombreCliente(result.getString("nombre_cliente"));
				cliente.setTelefonoCliente(result.getString("telefono_cliente"));
				clientes.add(cliente);
			}

			result.close();
			connection.connection.close();
			statement.close();

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			System.out.print("listar");
		}
		return clientes;
	}
}
