package edu.com.les19_java_hw_notebook.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import edu.com.les19_java_hw_notebook.entity.*;
import edu.com.les19_java_hw_notebook.logic.NoteBookLogic;

public class Main {

	public static void main(String[] args) throws ParseException {
		NoteBookProvider provider = NoteBookProvider.getInstance();
		NoteBookLogic logic = new NoteBookLogic();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Создать запись.");
			System.out.println("2. Найти записи по содержимому.");
			System.out.println("3. Найти записи по дате создания.");
			System.out.println("4. Показать все записи.");
			System.out.println("5. Выход.");

			if (scanner.hasNextInt()) {
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					System.out.print("Введите содержимое записи: ");
					String content = scanner.nextLine();
					provider.addNote(content);
					break;
				case 2:
					System.out.print("Введите текст для поиска: ");
					String searchText = scanner.nextLine();
					List<Note> notesByContent = logic.findNotesByContent(provider.getAllNotes(), searchText);
					for (Note note : notesByContent) {
						System.out.println(note.toString());
					}
					break;
				case 3:
				    System.out.print("Введите дату для поиска (дд.мм.гггг): ");
				    String dateString = scanner.nextLine();
				    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				    Date searchDate = dateFormat.parse(dateString);
				    List<Note> notesByDate = logic.findNotesByDate(provider.getAllNotes(), searchDate);
				    for (Note note : notesByDate) {
				        System.out.println(note.toString());
				    }
				    break;
				case 4:
					List<Note> allNotes = provider.getAllNotes();
					for (Note note : allNotes) {
						System.out.println(note.toString());
					}
					break;
				case 5:
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Некорректный выбор, попробуйте еще раз.");
				}
			} else {
				System.out.println("Некорректный ввод, попробуйте еще раз.");
				scanner.next();
			}
		}
	}

}
