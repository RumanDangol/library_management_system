package program;


import java.io.BufferedReader;

import java.io.InputStreamReader;


import java.util.ArrayList;
import java.util.List;


import admin.AdminDaoImpl;
import book.Book;

import staff.Staff;
import staff.StaffDAOImpl;
import student.Student;
import student.StudentDAOImpl;

public class mainProgram {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Welcome to Library Management System: \n");
		
	
		/**
		 * main starting program exit
		 */
		Boolean exitMain = true;
		/**
		 * loop for the program until user input 3 in main system
		 */
		while(exitMain != false) {
			/**
			 * buffered reader is used to  get input from the user
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
			
			/**
			 * Main menu
			 */
			System.out.println("Choose User: \n");
			System.out.println("0. \t Admin \n");
			System.out.println("1. \t Staff \n");
			System.out.println("2. \t Student \n");
			System.out.println("3. \t Exit \n");
		
		System.out.println("\n");
		int user = Integer.parseInt(br.readLine());
		
			switch (user) {
				
				
				case 0: 
					TestForAdmin admin = new TestForAdmin();
					admin.AdminWorks();

					
					
					
					break;
				case 1:
					TestForStaff staff = new TestForStaff();
					staff.StaffWorks();
				
					break;
				case 2:
					TestForStudent student = new TestForStudent();
					student.StudentWorks();
				
					break;
				case 3:
					exitMain = false;
					
					
					break;
				default:
					System.err.println("\n Choose correct Numbers");
					break;
			}
			
			
		}
		exitTerminal();
		}
		
		
		
	
		/**
		 * test for add staff
		 * 
		 */
		//AdminDaoImpl implementTest1 = new AdminDaoImpl();
		//implementTest1.addStaff("sanjay", "sanjay");
		
		/**
		 * test to show all staff names
		 */
		//showStaff();
		
		/**
		 * test to update staff where getting old name and changing into
		 * new staff name and new staff password
		 */
		//AdminDaoImpl implementTest1 = new AdminDaoImpl();
		//implementTest1.updateStaff("Sajan Sharma", "Ruman Dangol", "Ruman Dangol");
		
		/**
		 * test to show all students by staff
		 */
		//showStudent();
		
		/**
		 * test to get book
		 */
		//StudentDAOImpl implementTest3 = new  StudentDAOImpl();
		//implementTest3.returnBook("web");
		
		/**
		 * 
		 *test to show available books
		 */
		//showBookAvailable();
	
	
	public static void showStaff() {
		AdminDaoImpl implementTest1 = new AdminDaoImpl();
		List<Staff> staffs = new ArrayList<Staff>();
		staffs = implementTest1.viewAllStaff();
		int len = staffs.size(), i=0;
		while(i<len) {
			System.out.println(staffs.get(i).getName());
			i++;
			
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
	public static void showBookAvailable() {
		StudentDAOImpl implementTest3 = new StudentDAOImpl();
		List<Book> books = new ArrayList<Book>();
		books = implementTest3.viewBooksAvailable();
		int len = books.size(), i=0;
		Boolean check = true;
		while(i<len) {
			if(books.get(i).getIsAvailable() == check) {
				
				System.out.println(books.get(i).getBookId() + "\n" + books.get(i).getName());
			}
			i++;
			
		}

	}
	public static void exitTerminal() {
		
		System.exit(0);

	}

}



