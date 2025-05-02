package main;

import model.Note;
import view.NoteFrame;

public class Launcher {
	public static void main(String[] args) {
		Note note = new Note("A New Note","This is a description of a note");
		
		System.out.print(note.getNote());
		
		NoteFrame frame = new NoteFrame(note);
		frame.OpenNote();
	}
}
