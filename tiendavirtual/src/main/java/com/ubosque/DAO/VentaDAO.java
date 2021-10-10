package com.ubosque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ubosque.DTO.Ventas;

public class VentaDAO {

	public ArrayList<Ventas> listarVentas() {
		ArrayList<Ventas> ventas = new ArrayList<>();
		Connection connection = new Connection();
		try {
			String query = "select * from ventas";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Ventas venta = new Ventas();
				venta.setCodigoVenta(resultSet.getInt("codigo_venta"));
				venta.setCedulaCliente(resultSet.getInt("codigo_cliente"));
				venta.setCedulaUsuario(resultSet.getInt("cedula_usuario"));
				venta.setIvaVenta(resultSet.getDouble("ivaventa"));
				venta.setTotalVenta(resultSet.getDouble("total_venta"));
				venta.setValorVenta(resultSet.getDouble("valor_venta"));

				ventas.add(venta);
			}
			statement.close();
			resultSet.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return ventas;
	}

	public void addVenta(Ventas venta) {
		Connection connection = new Connection();
		try {
			String query = "insert into ventas (cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, venta.getCedulaCliente());
			statement.setInt(2, venta.getCedulaUsuario());
			statement.setDouble(3, venta.getIvaVenta());
			statement.setDouble(4, venta.getValorVenta());
			ResultSet resultSet = statement.executeQuery();

			if (resultSet != null) {
				System.out.println("Venta agregada");
			} else {
				System.out.println("Venta No agregada");
			}

			statement.close();
			resultSet.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteVentas(int codigoVentas) {
		Connection connection = new Connection();
		try {

			String query = "delete from ventas where codigo_venta = ?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, codigoVentas);
			int result = statement.executeUpdate();

			if (result == 1) {
				System.out.print("Usuario Eliminado");
			} else {
				System.out.print("Ha ocurrido un error");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}