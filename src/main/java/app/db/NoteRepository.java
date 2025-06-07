package main.java.app.db;

import java.sql.Connection;

public class NoteRepository {
	private DatabaseManager dbManager;
	
	public NoteRepository(DatabaseManager dbManager) {
		this.dbManager = dbManager;
	}
}
