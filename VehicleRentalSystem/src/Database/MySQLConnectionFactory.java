package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory implements ConnectionFactory {
	
	private static final String  URL = "jdbc:mysql://localhost:3306/vehiclemanagementsystem?user=root";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "682682";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}

}
