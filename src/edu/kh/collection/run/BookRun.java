package edu.kh.collection.run;

import edu.kh.collection.model.service.BookService;

public class BookRun {

	public static void main(String[] args) {
		
		BookService bs = new BookService();
		
		bs.displayMenu();
	}
}
