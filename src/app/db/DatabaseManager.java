package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	private Connection connection;
	private static final String DataBase_URL = "jdbc:sqlite:data/NotesData.db";
	private static DatabaseManager instance;
	
	private DatabaseManager() {
		try {
			// Load the SQLite JDBC driver
			Class.forName("org.sqlite.JDBC");
			
			// Create connection
			connection = DriverManager.getConnection(DataBase_URL);
			try (Statement stmt = connection.createStatement()) {
			    stmt.execute("PRAGMA foreign_keys = ON;");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseManager getInstance() {
		if (instance == null) {
			instance = new DatabaseManager();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(DataBase_URL);
		}
		return connection;
	}
	
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		instance = null; // Reset the instance to allow for reinitialization
	}
}
