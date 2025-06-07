package main.java.app.services;

import main.java.app.db.NoteRepository;

public class NoteService {
	private NoteRepository noteRepository;
	
	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
}
