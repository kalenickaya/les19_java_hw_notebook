package edu.com.les19_java_hw_notebook.entity;

import java.util.ArrayList;
import java.util.List;

public class NoteBookProvider {

	private List<Note> notes;
	private static NoteBookProvider instance;
	
	private	NoteBookProvider() {
		notes = new ArrayList<>();
	}
	
 	public void addNote(String content) {
 		notes.add(new Note(content));
 	}

	public List<Note> getAllNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public static NoteBookProvider getInstance() {
		if (instance == null) {
			instance = new NoteBookProvider();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "NoteBookProvider [notes = " + notes + "]";
	}
	
}
