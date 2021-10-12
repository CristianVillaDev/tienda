package com.ubosque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ubosque.DTO.DetallesVentas;

public class DetalleVentaDAO {

	public ArrayList<DetallesVentas> listarDetalleVentas() {
		ArrayList<DetallesVentas> detalles = new ArrayList<>();
		Connection connection = new Connection();

		try {
			String query = "select * from detalle_ventas";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				DetallesVentas detalleventa = new DetallesVentas();

				detalleventa.setCodigoDetalleVenta(result.getInt("codigo_detalle_venta"));
				detalleventa.setCantidadProducto(result.getInt("cantidad_producto"));
				detalleventa.setCodigoProducto(result.getInt("codigo_producto"));
				detalleventa.setCodigoVenta(result.getInt("codigo_venta"));
				detalleventa.setValorTotal(result.getDouble("valor_total"));
				detalleventa.setValorVenta(result.getDouble("valor_venta"));
				detalleventa.setValorIva(result.getDouble("valoriva"));

				detalles.add(detalleventa);
			}

			statement.close();
			result.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return detalles;
	}

	public void addDetalleVenta(DetallesVentas detalleventas) {
		Connection connection = new Connection();

		try {
			String query = "select max(codigo_detalle_venta) as codigo_detalle_venta from detalle_ventas";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();
			int codigo_detalle = 0;
			while (resultSet.next()) {
				codigo_detalle = resultSet.getInt("codigo_detalle_venta");
			}

			query = "INSERT INTO detalle_ventas(codigo_detalle_venta,cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_venta,valoriva) VALUES (?,?,?,?,?,?,?)";
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, codigo_detalle +1);
			statement.setInt(2, detalleventas.getCantidadProducto());
			statement.setInt(3, detalleventas.getCodigoProducto());
			statement.setInt(4, detalleventas.getCodigoVenta());
			statement.setDouble(5, detalleventas.getValorTotal());
			statement.setDouble(6, detalleventas.getValorVenta());
			statement.setDouble(7, detalleventas.getValorIva());
			
			int result = statement.executeUpdate();
			if (result == 0) {
				System.out.println("Detalle venta no agregado");
			} else {
				System.out.println("Detalle venta agregada");
			}
			
			statement.close();
			connection.connection.close();
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}