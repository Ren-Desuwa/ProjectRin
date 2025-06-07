package main.java.app;
import main.java.app.db.BlockRepository;
import main.java.app.db.DatabaseManager;
import main.java.app.db.NoteRepository;
import main.java.app.services.BlockService;
import main.java.app.services.NoteService;
import main.java.app.ui.MainMenu;


public class App {
	
	private NoteRepository noteRepository;
	private BlockRepository blockRepository;
	
	private NoteService noteService;
	private BlockService blockService;
	
	
	public App() {
		// Initialize the application
		DatabaseManager dbManager = DatabaseManager.getInstance();
		
		blockRepository = new BlockRepository(dbManager);
		noteRepository = new NoteRepository(dbManager);

		blockService = new BlockService(blockRepository);
		noteService = new NoteService(noteRepository);
		
	}
	
	public void start() {
		System.out.println("Application started.");
		MainMenu.showMainMenu(blockService, noteService);
	}
}
