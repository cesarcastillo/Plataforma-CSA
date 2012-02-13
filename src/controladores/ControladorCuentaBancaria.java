package controladores;

import entidades.CuentaBancaria;
import conexion.ConexionMySQL;
import java.sql.*;

public class ControladorCuentaBancaria {

	public static void main(String args[]){
		//Empty main
	}
	//Busqueda de cuenta por ID
	public static CuentaBancaria obtenerEntidadPorId(int id){
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		String query = "SELECT * FROM CuentaBancaria WHERE id = '" + id + "'";
		
		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				cuentaBancaria.setId(rs.getInt("id"));
				cuentaBancaria.setSaldo(rs.getDouble("saldo"));
				cuentaBancaria.setSociedadId(rs.getInt("sociedadId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuentaBancaria;
	}
	
	//Borrar Cuenta por ID
	public static void borrarEntidadPorId(int id){
		String query = "DELETE FROM CuentaBancaria WHERE id ='" + id + "'";

		try {
			Connection connection = ConexionMySQL.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Crear Cuenta apartir de un objeto
	public static int crearEntidad(CuentaBancaria cuentaBancaria) {		
		int id = 0;
		
		String query = 
				"INSERT INTO CuentaBancaria (saldo, sociedadID VALUES(" +
				"'" + cuentaBancaria.getSaldo()				+ "', " +
				"'" + cuentaBancaria.getSociedadId()		+ "')";
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
	
	//Actualiza Cuenta
	public static void actualizarEntidad(CuentaBancaria cuentaBancaria){
		Connection connection = ConexionMySQL.getConnection();
		String query =
				"UPDATE CuentaBancaria SET " +
		
				"saldo = '" + cuentaBancaria.getSaldo() 				+ "', " +
				"sociedadId = '" + cuentaBancaria.getSociedadId() 		+ "' " +
				
				"where id = '" + cuentaBancaria.getId() + "'";

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
