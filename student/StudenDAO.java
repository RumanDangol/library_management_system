package student;

import java.util.List;

import book.Book;

public abstract interface StudenDAO {
	public void getBook(int bookID, int studentID);
	public void returnBook(int  bookID, int studentID);
	List<Book> viewBooksAvailable();
	
}
