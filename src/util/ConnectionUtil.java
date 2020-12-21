package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:data/databases/cornerCoffeeDB.sqlite");
		} catch (Exception e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}

		return null;
	}

	public static boolean closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
				return true;
			} catch (SQLException e) {
				System.out.println("Failed closing connection");
				e.printStackTrace();
			}
		} else {
			return false;
		}
		return false;
	}
}
