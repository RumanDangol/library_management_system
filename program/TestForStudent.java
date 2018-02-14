package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.Book;
import database.DBConnect;

import student.Student;
import student.StudentDAOImpl;

public class TestForStudent {
	public void StudentWorks() throws  IOException, NullPointerException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Welcome Student \n");
		System.out.println("Enter Student Name : \n");
		String studentName = br.readLine();
		System.out.println("Enter Student password : \n");
		String studentPassword = br.readLine();
		System.out.println("\n");
		
		List<Student> students = new ArrayList<Student>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Boolean validStudent = false;
		
		try {
			connection = DBConnect.startMySQLConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM student";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Student student = new Student();
				student.setStudentName(resultSet.getString("student_name"));
				student.setStudentPassword(resultSet.getString("student_password"));
				students.add(student);
				}
			
			for(int i=0; i< students.size();i++) {
				
				if(studentName.equals(students.get(i).getStudentName()) && studentPassword.equals(students.get(i).getStudentPassword())) {
					validStudent = true;
				}else {
					validStudent = false;
				}
			}
			try {
				
				if(validStudent == true){
					Boolean exitStudent = true;
					while(exitStudent != false) {
						StudentDAOImpl implementStudent = new StudentDAOImpl();
						System.out.println("Choose What you want to do : \n");
						System.out.println("0. \t Get Book \n");
						System.out.println("1. \t Return Book \n");
						System.out.println("2. \t View Books Available \n");
						System.out.println("3. \t Exit \n");
						
						int studentTask = Integer.parseInt(br.readLine());
						
						switch (studentTask) {
						case 0:
							System.out.println("Enter Book ID : \n");
							int bookIDForGet = Integer.parseInt(br.readLine());
							System.out.println("Enter Student ID : \n");
							int studentIDForGetBook = Integer.parseInt(br.readLine());
							System.out.println("\n");
							
							implementStudent.getBook(bookIDForGet, studentIDForGetBook);
							break;
						case 1:
							System.out.println("Enter Book ID : \n");
							int bookIDForReturn = Integer.parseInt(br.readLine());
							System.out.println("Enter Student ID : \n");
							int studentIDForReturn = Integer.parseInt(br.readLine());
							implementStudent.returnBook(bookIDForReturn, studentIDForReturn);
							break;
						
						case 2:
							showBookAvailable();
							break;
						case 3:
							exitStudent = false;
							break;
						default:
							System.err.println("Choose valid task ");
							
							break;
						
						
						}
							
						
						
						
					}
					
				}else if (validStudent == false) {
					
					System.err.println("You are not Student \n \n");
				}
				
			
			}catch(NumberFormatException numberFormat) {
				System.err.println(numberFormat);
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



		
	}
	public static void showBookAvailable() {
		StudentDAOImpl implementTest3 = new StudentDAOImpl();
		List<Book> books = new ArrayList<Book>();
		books = implementTest3.viewBooksAvailable();
		int len = books.size(), i=0;
		Boolean check = true;
		while(i<len) {
			if(books.get(i).getIsAvailable() == check) {
				
				System.out.println(books.get(i).getBookId() + "\t" + books.get(i).getName());
			}
			i++;
			
		}

	}
}
