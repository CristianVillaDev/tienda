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
				venta.setCedulaCliente(resultSet.getInt("cedula_cliente"));
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

	public ArrayList<Ventas> listarVenta(int codigo_venta) {
		ArrayList<Ventas> ventas = new ArrayList<>();
		Connection connection = new Connection();
		try {
			String query = "select * from ventas where codigo_venta=?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, codigo_venta);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Ventas venta = new Ventas();
				venta.setCodigoVenta(resultSet.getInt("codigo_venta"));
				venta.setCedulaCliente(resultSet.getInt("cedula_cliente"));
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
	
	public int listarVentaID() {
		int codigo = 0;
		Connection connection = new Connection();
		try {
			String query = "select max(codigo_venta) as codigo from ventas";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				codigo = resultSet.getInt("codigo");
			}
			
			statement.close();
			resultSet.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return codigo;
	}

	public void addVenta(Ventas venta) {
		Connection connection = new Connection();
		try {

			String query = "select max(codigo_venta) as codigo_v from ventas";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();
			int codigo_venta = 0;
			while (resultSet.next()) {
				codigo_venta = resultSet.getInt("codigo_v");
			}

			query = "insert into ventas (codigo_venta,cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) values(?,?,?,?,?,?)";
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, codigo_venta + 1);
			statement.setInt(2, venta.getCedulaCliente());
			statement.setInt(3, venta.getCedulaUsuario());
			statement.setDouble(4, venta.getIvaVenta());
			statement.setDouble(5, venta.getTotalVenta());
			statement.setDouble(6, venta.getValorVenta());

			int resultado = statement.executeUpdate();

			if (resultado != 0) {
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

	public void updateVenta(Ventas venta, int codigo_venta) {
		Connection connection = new Connection();
		try {
			String query = "select * from ventas where codigo_venta =?";

			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, codigo_venta);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				query = "update ventas set cedula_cliente = ?, cedula_usuario =?,ivaventa=?,total_venta=?,valor_venta=? where codigo_venta=?";
				statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, venta.getCedulaCliente());
				statement.setInt(2, venta.getCedulaUsuario());
				statement.setDouble(3, venta.getIvaVenta());
				statement.setDouble(4, venta.getTotalVenta());
				statement.setDouble(5, venta.getValorVenta());
				statement.setInt(6, codigo_venta);

				int resultado = statement.executeUpdate();
				if (resultado == 1) {
					System.out.print("Venta actualizada");
				} else {
					System.out.print("Venta No actualizada");
				}
			}
			statement.close();
			result.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}