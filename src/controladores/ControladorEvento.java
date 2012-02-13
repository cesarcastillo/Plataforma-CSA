package controladores;

import entidades.Evento;
import conexion.ConexionMySQL;
import java.sql.*;

public class ControladorEvento {
	
	public static void main(String args[]){
		//Empty main
	}
	//Busqueda de Evento por ID
	public static Evento obtenerEntidadPorId(int id){
		Evento evento = new Evento();
		String query = "SELECT * FROM CuentaBancaria WHERE id = '" + id + "'";
		
		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				evento.setId(rs.getInt("id"));
				evento.setSociedadId(rs.getInt("sociedadId"));
				evento.setNombre(rs.getString("nombre"));
				evento.setDescripcion(rs.getString("descripcion"));
				evento.setFechaInicio(rs.getDate("fechaInicio"));
				evento.setFechaFin(rs.getDate("fechaFin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evento;
	}
	
	//Borrar Evento por ID
	public static void borrarEntidadPorId(int id){
		String query = "DELETE FROM Evento WHERE id ='" + id + "'";

		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Crear Evento apartir de un objeto
	public static int crearEntidad(Evento evento) {		
		int id = 0;
		
		String query = 
				"INSERT INTO Evento (saldo, sociedadID VALUES(" +
				"'" + evento.getSociedadId()		+ "', " +
				"'" + evento.getNombre()			+ "', " +
				"'" + evento.getDescripcion()		+ "', " +
				"'" + evento.getFechaInicio()		+ "', " +
				"'" + evento.getFechaFin()			+ "')";
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
	
	//Actualiza Evento
	public static void actualizarEntidad(Evento evento){
		Connection connection = ConexionMySQL.getConnection();
		String query =
				"UPDATE CuentaBancaria SET " +
		
				"sociedadId = '" + 	evento.getSociedadId()		+ "', " +
				"nombre = '" +  evento.getNombre()				+ "', " +
				"descripcion = '" +  evento.getDescripcion()	+ "', " +
				"fechaInicio = '" +  evento.getFechaInicio()	+ "', " +
				"fechaFin = '" +  evento.getFechaFin()			+ "' " +
				
				"where id = '" + evento.getId() + "'";

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
