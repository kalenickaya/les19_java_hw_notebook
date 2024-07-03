package edu.com.les19_java_hw_notebook.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import edu.com.les19_java_hw_notebook.entity.*;

public class NoteBookLogic {

	public List<Note> findNotesByContent(List<Note> notes, String searchContent) {
		List<Note> foundNotes = new ArrayList<>();
		for (Note note : notes) {
			if (note.getContent().contains(searchContent)) {
				foundNotes.add(note);
			}
		}
		return foundNotes;
	}

	public List<Note> findNotesByDate(List<Note> notes, Date searchDate) {
		List<Note> foundNotes = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String searchDateString = dateFormat.format(searchDate);
		for (Note note : notes) {
			String noteCreationDateString = dateFormat.format(note.getCreationDate());
			if (searchDateString.equals(noteCreationDateString)) {
				foundNotes.add(note);
			}
		}
		return foundNotes;
	}

}
