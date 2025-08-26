package bbrown2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBase {

	private static String URL = "jdbc:mysql://localhost:3306/pokemoncards";
	private static String USER = "root";
	private static String PASS = "";

	private static Connection conn;
	private static dataBase instance;

	private dataBase() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}
	
	// Singleton accessor
	public static dataBase getInstance() {
		if (instance == null) {
			instance = new dataBase();
		}
		return instance;
	}

	public Connection getConnection() {
		return conn;
	}
}
