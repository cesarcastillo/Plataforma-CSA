package controladores;

import entidades.Usuario;
import conexion.ConexionMySQL;

import java.sql.*;

public class ControladorUsuario {
	
	public static void main(String args[]){
		//Aqui se puede probar el codigo. (Si pudieran reiniciar la JVM del servidor)
	}

	public static Usuario obtenerEntidadPorId(int id){
		Usuario usuario = new Usuario();
		String query = "SELECT * FROM Usuario WHERE id = '" + id + "'";
		
		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setTipo(rs.getInt("tipo"));
				usuario.setSociedadId(rs.getInt("sociedadId"));
				usuario.setMatricula(rs.getString("matricula"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPermisos(rs.getString("permisos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public static void borrarEntidadPorId(int id){
		String query = "DELETE FROM Usuario WHERE id ='" + id + "'";

		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int crearEntidad(Usuario usuario) {		
		int id = 0;
		
		String query = 
				"INSERT INTO Usuario (tipo, sociedadId, matricula, " +
				"password, nombre, permisos) VALUES(" +
				"'" + usuario.getTipo() 		+ "', " +
				"'" + usuario.getSociedadId() 	+ "', " +
				"'" + usuario.getMatricula()	+ "', " +
				"'" + usuario.getPassword()		+ "', " +
				"'" + usuario.getNombre()		+ "', " +
				"'" + usuario.getPermisos()		+ "')";
		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static void actualizarEntidad(Usuario usuario){
		Connection connection = ConexionMySQL.getConnection();
		String query =
				"UPDATE Usuario SET " +
		
				"tipo = '" + usuario.getTipo() 					+ "', " +
				"sociedadId = '" + usuario.getSociedadId() 		+ "', " +
				"matricula = '" + usuario.getMatricula() 		+ "', " +
				"password = '" + usuario.getPassword() 			+ "', " +
				"nombre = '" + usuario.getNombre() 				+ "', " +
				"permisos = '" + usuario.getPermisos() 			+ "' " +
				
				"where id = '" + usuario.getId() + "'";

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
