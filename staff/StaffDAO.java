package staff;

import java.util.List;

import book.Book;
import student.Student;

public abstract interface StaffDAO {
	public void addStudent(String studentName, String studentPassword);
	public void deleteStudent(String studentName);
	public void updateStudent(String oldStudentName, String newStudenName, String newStudentPassword);
	List<Student> viewAllStudents();
	public void addBook(String bookName, String bookPublisher);
	public void deleteBook(String bookName);
	public void updateBook(int bookID, String newBookName, String newBookPublisher);
	List<Book> viewAllBooks();
}
