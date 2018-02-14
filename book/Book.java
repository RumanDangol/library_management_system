package book;

public class Book {
	private int bookId;
	private Boolean isAvailable;
	private int studentId;
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	private String name;
	private String publisher;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Book(String name, String publisher) {
		super();
		this.name = name;
		this.publisher = publisher;
	}
	public Book() {
		
	}
}
