package data_access_objects;

import java.sql.Connection;

public class DataAccessObjectManager {
	private Connection connection;
	private static final String DataBase_URL = "jdbc:sqlite:database/NotesData.db";
	private static DataAccessObjectManager instance;
	private BlockDataAccessObject blockDataAccessObject;
	
	private DataAccessObjectManager() {
		try {
			// Load the SQLite JDBC driver
			Class.forName("org.sqlite.JDBC");
			
			// Create connection
			connection = java.sql.DriverManager.getConnection(DataBase_URL);
			
			// Initialize data access objects
			initializeDataAccessObjects();
			
		} catch (ClassNotFoundException | java.sql.SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DataAccessObjectManager getInstance() {
		if (instance == null) {
			instance = new DataAccessObjectManager();
		}
		return instance;
	}
	
	private void initializeDataAccessObjects() {
		this.blockDataAccessObject = new BlockDataAccessObject(connection);
	}
	
	public BlockDataAccessObject getBlockDataAccessObject() {
		return blockDataAccessObject;
	}
	
}
