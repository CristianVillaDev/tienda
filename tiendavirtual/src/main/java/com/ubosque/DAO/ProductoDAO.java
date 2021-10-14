package com.ubosque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ubosque.DTO.Productos;

public class ProductoDAO {

	public ArrayList<Productos> listarProductos() {
		ArrayList<Productos> productos = new ArrayList<>();
		Connection connection = new Connection();
		try {
			String query = "select * from productos";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Productos producto = new Productos();

				producto.setCodigoProducto(result.getInt("codigo_producto"));
				producto.setNombreProducto(result.getString("nombre_producto"));
				producto.setNitProveedor(result.getInt("nitproveedor"));
				producto.setPrecioCompra(result.getDouble("precio_compra"));
				producto.setIvaCompra(result.getDouble("ivacompra"));
				producto.setPrecioVenta(result.getDouble("precio_venta"));

				productos.add(producto);
			}

			statement.close();
			connection.connection.close();
			result.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return productos;
	}

	public ArrayList<Productos> listarProducto(int codigoProducto) {
		ArrayList<Productos> productos = new ArrayList<>();
		Connection connection = new Connection();
		try {
			String query = "select * from productos where codigo_producto=?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, codigoProducto);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Productos producto = new Productos();

				producto.setCodigoProducto(result.getInt("codigo_producto"));
				producto.setNombreProducto(result.getString("nombre_producto"));
				producto.setNitProveedor(result.getInt("nitproveedor"));
				producto.setPrecioCompra(result.getDouble("precio_compra"));
				producto.setIvaCompra(result.getDouble("ivacompra"));
				producto.setPrecioVenta(result.getDouble("precio_venta"));

				productos.add(producto);
			}

			statement.close();
			result.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return productos;
	}

	public void createProduct(Productos producto) {
		Connection connection = new Connection();
		try {
			String query = "insert into productos (codigo_producto,ivaventa,nitproveedor,nombre_producto,precio_compra,precio_venta) values(?,?,?,?,?,?)";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, producto.getCodigoProducto());
			statement.setDouble(2, producto.getIvaCompra());
			statement.setInt(3, producto.getNitProveedor());
			statement.setString(4, producto.getNombreProducto());
			statement.setDouble(5, producto.getPrecioCompra());
			statement.setDouble(6, producto.getPrecioVenta());

			statement.executeUpdate();

			System.out.println("Se agregó el producto");

			statement.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateProduct(Productos producto) {
		Connection connection = new Connection();
		try {

			String query = "select * from productos where codigo_producto = ?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, producto.getCodigoProducto());
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				query = "update productos set ivaventa =?,nitproveedor=?,nombre_producto=?,precio_compra=?,precio_venta=? where codigo_producto=?";
				statement = connection.getConnection().prepareStatement(query);

				statement.setDouble(1, producto.getIvaCompra());
				statement.setInt(2, producto.getNitProveedor());
				statement.setString(3, producto.getNombreProducto());
				statement.setDouble(4, producto.getPrecioCompra());
				statement.setDouble(5, producto.getPrecioVenta());
				statement.setInt(6, producto.getCodigoProducto());

				statement.executeUpdate();

				result.close();
				connection.connection.close();
				statement.close();

				System.out.println("Se actualizo el producto");
			} else {
				System.out.print("Ha ocurrido un error - el producto no existe");
			}

			result.close();
			statement.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteAllProduct( ) {
		Connection connection = new Connection();
		try {
			String query = "delete from productos";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.executeUpdate();

			System.out.println("Se eliminarion los productos");

			statement.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void deleteProduct(int codigoProducto) {
		Connection connection = new Connection();
		try {
			String query = "delete from productos where codigo_producto=?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, codigoProducto);

			statement.executeUpdate();

			System.out.println("Se elimino el producto");

			statement.close();
			connection.connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
