package com.ubosque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.ubosque.DTO.Clientes;
import com.ubosque.DTO.Proveedores;

public class ProveedorDAO {

 
	public ArrayList<Proveedores> listarProveedores() {
		ArrayList<Proveedores> proveedores = new ArrayList<Proveedores>();
		Connection connection = new Connection();
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("Select * from proveedores");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitProveedor(result.getInt("nitproveedor"));
				proveedor.setCiudadProveedor(result.getString("ciudad_proveedor"));
				proveedor.setDireccionProveedor(result.getString("direccion_proveedor"));
				proveedor.setNombreProveedor(result.getString("nombre_proveedor"));
				proveedor.setTelefonoProveedor(result.getString("telefono_proveedor"));

				proveedores.add(proveedor);
			}
			// cerrar conexion con la BD
			result.close();
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "no se pudo realizar la consulta\n" + e);
		}
		return proveedores;
	}

 
	public void crearProveedor(Proveedores proveedor) {
		Connection connection = new Connection();
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(
					"insert into proveedores (nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor) values (?,?,?,?,?)");
			statement.setInt(1, proveedor.getNitProveedor());
			statement.setString(2, proveedor.getCiudadProveedor());
			statement.setString(3, proveedor.getDireccionProveedor());
			statement.setString(4, proveedor.getNombreProveedor());
			statement.setString(5, proveedor.getTelefonoProveedor());
			int result = statement.executeUpdate();

			if (result == 1) {
				System.out.print("Usuario agregado");
			} else {
				System.out.print("Ha ocurrido un error");
			}

			statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

 
	public void deleteProveedor(int nitproveedor) {
		Connection connection = new Connection();

		try {

			PreparedStatement statement = connection.getConnection()
					.prepareStatement("delete from proveedores where nitproveedor=?");
			statement.setInt(1, nitproveedor);

			int result = statement.executeUpdate();

			if (result == 1) {
				System.out.print("Usuario Eliminado");
			} else {
				System.out.print("Ha ocurrido un error");
			}

			statement.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

 
	public void updateProveedor(Proveedores proveedor) {
		Connection connection = new Connection();

		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("select * from proveedores where nitproveedor = ?");
			statement.setInt(1, proveedor.getNitProveedor());
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				statement = connection.getConnection().prepareStatement(
						"update proveedores set ciudad_proveedor=? ,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? where nitproveedor=?");
				statement.setString(1, proveedor.getCiudadProveedor());
				statement.setString(2, proveedor.getDireccionProveedor());
				statement.setString(3, proveedor.getNombreProveedor());
				statement.setString(4, proveedor.getTelefonoProveedor());
				statement.setInt(5, proveedor.getNitProveedor());

				int result2 = statement.executeUpdate();

				if (result2 == 1) {
					System.out.print("Usuario actualizado");
				}
			} else {
				System.out.print("Ha ocurrido un error");
			}
			result.close();
			statement.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

 
	public ArrayList<Proveedores> listarProveedor(int nitproveedor) {
		ArrayList<Proveedores> proveedores = new ArrayList<Proveedores>();
		Connection connection = new Connection();
		
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("select * from proveedores where nitproveedor=?");
			statement.setInt(1, nitproveedor);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitProveedor(result.getInt("nitproveedor"));
				proveedor.setCiudadProveedor(result.getString("ciudad_proveedor"));
				proveedor.setDireccionProveedor(result.getString("direccion_proveedor"));
				proveedor.setNombreProveedor(result.getString("nombre_proveedor"));
				proveedor.setTelefonoProveedor(result.getString("telefono_proveedor"));

				proveedores.add(proveedor);
			}
			
			result.close();
			statement.close();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			System.out.print("listar");
		}
		
		return proveedores;
	}

}
