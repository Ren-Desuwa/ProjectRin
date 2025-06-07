package app.services;

import app.db.NoteRepository;

public class NoteService {
	private NoteRepository noteRepository;
	
	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
}
