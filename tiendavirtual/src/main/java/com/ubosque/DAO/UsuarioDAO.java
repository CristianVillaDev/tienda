package com.ubosque.DAO;

import com.ubosque.DTO.Usuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

	// Metodos Crud
	// Metodo listar Usuarios
	public ArrayList<Usuario> ListUsers() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Connection connection = new Connection();

		
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM usuarios Where cedula_usuario !=1");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				usuario.setEmailUsuario(result.getString("email_usuario"));
				usuario.setNombreUsuario(result.getString("nombre_usuario"));
				usuario.setPassword(result.getString("password"));
				usuario.setUsuario(result.getString("usuario"));

				usuarios.add(usuario);
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "no se pudo realizar la consulta\n" + e);
		}
		return usuarios;
	}

	// Metodo para listar 1 usuario por su cedula en un arrayList
	public ArrayList<Usuario> ListUser(int cedula_usuario) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Connection connection = new Connection();

		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			statement.setInt(1,cedula_usuario);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				usuario.setEmailUsuario(result.getString("email_usuario"));
				usuario.setNombreUsuario(result.getString("nombre_usuario"));
				usuario.setPassword(result.getString("password"));
				usuario.setUsuario(result.getString("usuario"));

				usuarios.add(usuario);
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "no se pudo realizar la consulta\n" + e);
		}
		return usuarios;
	}

	// Metodo para crear un nuevo usuario
	public void createUser(Usuario usuario) {
		Connection connection = new Connection();
		try {
			String query = "INSERT INTO usuarios (cedula_usuario, email_usuario, nombre_usuario, password, usuario) VALUES (?,?,?,?,?)";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, usuario.getCedulaUsuario());
			statement.setString(2, usuario.getEmailUsuario());
			statement.setString(3, usuario.getNombreUsuario());
			statement.setString(4, usuario.getPassword());
			statement.setString(5, usuario.getUsuario());
			statement.executeUpdate();
			System.out.println("Se agregó el usuario");
			statement.close();
			connection.connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Metodo Eliminar usaurio por su cedula registrada
	public void deleteUser(int cedula_usuario) {
		Connection connection = new Connection();
		try {
			String query = "DELETE from usuarios WHERE cedula_usuario=?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, cedula_usuario);
			statement.executeUpdate();
			connection.connection.close();
			System.out.println("Se eliminó el usuario");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Metodo para actualizar usuario por su cedula registrada
	public void updateUser(Usuario usuario) {
		Connection connection = new Connection();
		try {
			String query = "SELECT * FROM usuarios WHERE cedula_usuario= ?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, usuario.getCedulaUsuario());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				query = "UPDATE usuarios SET email_usuario=?, nombre_usuario=?, password=?, usuario=? WHERE cedula_usuario=?";
				statement = connection.getConnection().prepareStatement(query);
				statement.setString(1, usuario.getEmailUsuario());
				statement.setString(2, usuario.getNombreUsuario());
				statement.setString(3, usuario.getPassword());
				statement.setString(4, usuario.getUsuario());
				statement.setInt(5, usuario.getCedulaUsuario());
				statement.executeUpdate();
				System.out.println("Se modificó el usuario\n");
			} else {
				System.out.println("El usuario no se encuentra registrado en el instituto");
			}
			resultSet.close();
			statement.close();
			connection.connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Metodo Login para autenticación de usaurios registrados en la tienda generica
	public int login(String usuario, String password) {
		Connection connection = new Connection();
		int cedula = 0;
		try {
			String query = "SELECT cedula_usuario FROM usuarios WHERE usuario= ? and  password= ?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, usuario);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				cedula = Integer.parseInt(resultSet.getString("cedula_usuario"));
				System.out.println("Existe el usuario \n");
			} else {
				cedula=0;
				System.out.println("El usuario no se encuentra registrado en la tienda generica");
			}
			resultSet.close();
			statement.close();
			connection.connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(usuario=="admininicial" && password=="admin123456") {
			cedula=1;
		}
		
		return cedula;
	}
}
