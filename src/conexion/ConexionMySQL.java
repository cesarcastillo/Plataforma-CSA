package conexion;
import java.sql.*;


public class ConexionMySQL {
	private static Connection connection;
	private static String hostPortDBName = "jdbc:mysql://localhost:3306/laygr_csa";
	private static String user = "laygr_csa";
	private static String password = "csa1234";

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(hostPortDBName, user, password);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
