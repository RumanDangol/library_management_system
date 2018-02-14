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
import staff.Staff;
import staff.StaffDAOImpl;
import student.Student;

public class TestForStaff {
	
	public void StaffWorks() throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("Welcome Staff \n");
	System.out.println("Enter Staff Name : \n");
	String staffName = br.readLine();
	System.out.println("Enter Staff password : \n");
	String staffPassword = br.readLine();
	System.out.println("\n");
	
	List<Staff> staffs = new ArrayList<Staff>();
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Boolean validStaff = false;
	
	try {
		connection = DBConnect.startMySQLConnection();
		statement = connection.createStatement();
		String sql = "SELECT * FROM staff";
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			Staff staff = new Staff();
			staff.setName(resultSet.getString("staff_name"));
			staff.setPassword(resultSet.getString("staff_password"));
			staffs.add(staff);
			}
		
		for(int i=0; i< staffs.size();i++) {
			
			if(staffName.equals(staffs.get(i).getName()) && staffPassword.equals(staffs.get(i).getPassword())) {
				validStaff = true;
			}else {
				validStaff = false;
			}
		}
		try {
			
			if(validStaff == true){
				Boolean exitStaff = true;
				while(exitStaff != false) {
					StaffDAOImpl implementStaff = new StaffDAOImpl();
					System.out.println("Choose What you want to do : \n");
					System.out.println("0. \t Add Student \n");
					System.out.println("1. \t Delete Student \n");
					System.out.println("2. \t View all Students \n");
					System.out.println("3. \t Update Student \n");
					System.out.println("4. \t Add Book \n");
					System.out.println("5. \t Delete Book \n");
					System.out.println("6. \t View all Books \n");
					System.out.println("7. \t Update Book \n");
					System.out.println("8. \t Exit \n");
					
					int staffTask = Integer.parseInt(br.readLine());
					
					switch (staffTask) {
					case 0:
						System.out.println("Enter Student Name : \n");
						String studentNameForAdd = br.readLine();
						System.out.println("Enter Student password : \n");
						String studentPasswordForAdd = br.readLine();
						System.out.println("\n");
						
						implementStaff.addStudent(studentNameForAdd, studentPasswordForAdd);
						break;
					case 1:
						System.out.println("Enter Student Name : \n");
						String staffNameForDelete = br.readLine();
						implementStaff.deleteStudent(staffNameForDelete);
						break;
					
					case 2:
						showStudent();
						break;
					case 3:
						System.out.println("Enter Old Student Name : \n");
						String studentOldNameForUpdate = br.readLine();
						System.out.println("Enter New Student Name : \n");
						String studentNewNameForUpdate = br.readLine();
						System.out.println("Enter New Student password : \n");
						String studentPasswordForUpdate = br.readLine();
						System.out.println("\n");
						implementStaff.updateStudent(studentOldNameForUpdate, studentNewNameForUpdate, studentPasswordForUpdate);
						break;
					case 4:
						System.out.println("Enter Book Name : \n");
						String bookNameForAdd = br.readLine();
						System.out.println("Enter Book Publisher : \n");
						String bookPublisherForAdd = br.readLine();
						System.out.println("\n");
						
						implementStaff.addBook(bookNameForAdd, bookPublisherForAdd);
						break;
					case 5:
						System.out.println("Enter Book Name : \n");
						String bookNameForDelete = br.readLine();
						implementStaff.deleteBook(bookNameForDelete);
						break;
					
					case 6:
						showBook();
						break;
					case 7:
						System.out.println("Enter  Book ID : \n");
						int bookID = Integer.parseInt(br.readLine());
						System.out.println("Enter New Book Name : \n");
						String bookNewNameForUpdate = br.readLine();
						System.out.println("Enter New Book Publisher : \n");
						String bookPusblisherForUpdate = br.readLine();
						System.out.println("\n");
						implementStaff.updateBook(bookID, bookNewNameForUpdate, bookPusblisherForUpdate);
						break;
					case 8:
						exitStaff = false;
						break;
					default:
						System.err.println("Choose valid task ");
						
						break;
					
					
					}
						
					
					
					
				}
				
			}else if (validStaff == false) {
				
				System.err.println("You are not Staff \n \n");
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
	public static void showStudent() {
		StaffDAOImpl implementTest2 = new StaffDAOImpl();
		List<Student> students = new ArrayList<Student>();
		students = implementTest2.viewAllStudents();
		int len = students.size(), i=0;
		while(i<len) {
			System.out.println(students.get(i).getStudentName());
			i++;
			
		}

	}
	public static void showBook() {
		StaffDAOImpl implementTest2 = new StaffDAOImpl();
		List<Book> books = new ArrayList<Book>();
		books = implementTest2.viewAllBooks();
		int len = books.size(), i=0;
		while(i<len) {
			System.out.println(books.get(i).getBookId() + "\t" + books.get(i).getName());
			i++;
			
		}

	}
}
