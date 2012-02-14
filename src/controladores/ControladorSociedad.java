package controladores;

import entidades.Sociedad;
import entidades.Usuario;
import conexion.ConexionMySQL;
import java.sql.*;

public class ControladorSociedad {
	
	public static void main(String args[]){
		//Empty main
	}
	//Busqueda de sociedad por ID
	public static Sociedad obtenerEntidadPorId(int id){
		Sociedad sociedad = new Sociedad();
		String query = "SELECT * FROM Sociedad WHERE id = '" + id + "'";
		
		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				sociedad.setId(rs.getInt("id"));
				sociedad.setNombre(rs.getString("nombre"));
				sociedad.setNombreMesa(rs.getString("nombreMesa"));
				sociedad.setFechaInicio(rs.getDate("fechaInicio"));
				sociedad.setFechaFin(rs.getDate("fechaFin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sociedad;
	}
	
	//Borrar Sociedad por ID
	public static void borrarEntidadPorId(int id){
		String query = "DELETE FROM Sociedad WHERE id ='" + id + "'";

		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Crear Sociedad apartir de un objeto
	public static int crearEntidad(Sociedad sociedad) {		
		int id = 0;
		
		String query = 
				"INSERT INTO Sociedad (nombre, nombreMesa, fechaInicio, " +
				"fechaFin) VALUES(" +
				"'" + sociedad.getNombre()			+ "', " +
				"'" + sociedad.getNombreMesa() 		+ "', " +
				"'" + sociedad.getFechaInicio()		+ "', " +
				"'" + sociedad.getFechaFin()		+ "')";
		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				id = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	//Actualiza Sociedad
	public static void actualizarEntidad(Sociedad sociedad){
		Connection connection = ConexionMySQL.getConnection();
		String query =
				"UPDATE Sociedad SET " +
		
				"nombre = '" + sociedad.getNombre() 				+ "', " +
				"nombreMesa = '" + sociedad.getNombreMesa() 		+ "', " +
				"fechaInicio = '" + sociedad.getFechaInicio() 		+ "', " +
				"fechaFin = '" + sociedad.getFechaFin() 			+ "' " +
				
				"where id = '" + sociedad.getId() + "'";

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//obtener todos los usuarios dado un sociedadId el método debe regresar un ArrayList<Usuario>
	//public static Usuario[] usuariosSociedad(int sociedadId){
		//String query = "SELECT * FROM Usuario WHERE sociedadId = '" + id + "'";
		
	//}
}
