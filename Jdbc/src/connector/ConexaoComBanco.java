package connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoComBanco {

	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/viajamar";

	private static String USER = "root";

	private static String PASSWORD = "Socadatj11";

	public static Connection createConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

		return conn;
		
	}

	public static void main(String[] args) throws Exception {
		Connection conn = createConnection();

		if (conn != null) {
			System.out.println("Conexão obtida com sucesso");
		} else {
			System.out.println("Erro ao conectar");
		}
	}

}