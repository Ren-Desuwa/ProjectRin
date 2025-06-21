package app;

import app.db.BlockRepository;
import app.db.DatabaseManager;
import app.db.NoteRepository;
import app.services.BlockService;
import app.services.NoteService;
import app.ui.view.MainMenu;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome Ren!");
		databaseInit();
		
		Application.launch(MainMenu.class, args);
	}
	
	private static void databaseInit() {
		// Initialize the database connection and repositories
		DatabaseManager dbManager = DatabaseManager.getInstance();
		
		NoteRepository noteRepository = new NoteRepository(dbManager);
		NoteService noteService = new NoteService(noteRepository);
		
		BlockRepository blockRepository = new BlockRepository(dbManager);
		BlockService blockService = new BlockService(blockRepository);
	}
}
