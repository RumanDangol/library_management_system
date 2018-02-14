package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.Book;
import database.DBConnect;
import student.Student;

public class StaffDAOImpl implements StaffDAO{

	@Override
	public void addStudent(String studentName, String studentPassword) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "INSERT INTO student (student_id, student_name, student_password)" +  "VALUES (NULL, ?, ?)";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, studentName);
			preparedstatement.setString(2, studentPassword);
			preparedstatement.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	@Override
	public void deleteStudent(String studentName) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "DELETE FROM student WHERE student.student_name = ? ";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, studentName);
			
			preparedstatement.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	@Override
	public void updateStudent(String oldStudentName, String newStudenName, String newStudentPassword) {

        
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "UPDATE student SET " + "student_name = ?, student_password = ? WHERE student_name = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, newStudenName);
			preparedstatement.setString(2, newStudentPassword);
			preparedstatement.setString(3, oldStudentName);
			preparedstatement.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
    
		
	}

	@Override
	public List<Student> viewAllStudents() {

		List<Student> students = new ArrayList<Student>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBConnect.startMySQLConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM student";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Student student = new Student();
				student.setStudentName(resultSet.getString("student_name"));
				students.add(student);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}

			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}

		return students;
	
		
	}

	@Override
	public void addBook(String bookName, String bookPublisher) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "INSERT INTO book(book_id, book_name, book_publisher, added_date) " +  "VALUES (NULL, ?, ?, CURRENT_TIMESTAMP)";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, bookName);
			preparedstatement.setString(2, bookPublisher);
			preparedstatement.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
	
		
	}

	@Override
	public void deleteBook(String bookName) {

		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "DELETE FROM book WHERE book.book_name = ? ";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, bookName);
			
			preparedstatement.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	
		
	}

	@Override
	public void updateBook(int bookID, String newBookName, String newBookPublisher) {

        
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "UPDATE book SET " + "book_name = ?, book_publisher = ? WHERE book.book_id = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, newBookName);
			preparedstatement.setString(2, newBookPublisher);
			preparedstatement.setInt(3, bookID);
			preparedstatement.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
    
		
	}

	@Override
	 public List<Book> viewAllBooks() {

		List<Book> books = new ArrayList<Book>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBConnect.startMySQLConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM book";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Book book = new Book();
				book.setName(resultSet.getString("book_name"));
				book.setBookId(resultSet.getInt("book_id"));
				books.add(book);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}

			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}

		return books;
	
		
	}

}
