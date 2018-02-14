package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.Book;
import database.DBConnect;

public class StudentDAOImpl implements StudenDAO{

	@Override
	public void getBook(int bookID, int studentID) {


		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "UPDATE book SET student_id = ?, isAvailable = 0 "+ "WHERE book.book_id = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, studentID);
			preparedstatement.setInt(2, bookID);
			
			
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
	public void returnBook(int bookID, int studentID) {



		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		Statement statement = null;
		Boolean validStudent = false;
		
		try{
			
			List<Book> books = new ArrayList<Book>();
			connection = DBConnect.startMySQLConnection();
			statement = connection.createStatement();
			String sql1 = "SELECT * FROM book";
			resultSet = statement.executeQuery(sql1);
			while(resultSet.next()) {
				Book book = new Book();
				book.setStudentId(resultSet.getInt("student_id"));
				books.add(book);
					
			}
			for(int i=0;i<books.size();i++) {
				if(studentID == books.get(i).getStudentId()) {
					validStudent = true;
				}
			}
			
				
				
			
			if(validStudent == true) {
				String sql = "UPDATE book SET  isAvailable = 1 "+ "WHERE book.book_id = ?";
				preparedstatement = connection.prepareStatement(sql);
			
				preparedstatement.setInt(1, bookID);
			
			
				preparedstatement.executeUpdate();
			}else {
				System.err.println("You donot have authority");
			}
			
			
			
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
	public List<Book> viewBooksAvailable() {


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
				book.setIsAvailable(resultSet.getBoolean("isAvailable"));
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
