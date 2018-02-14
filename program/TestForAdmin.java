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

import admin.Admin;
import admin.AdminDaoImpl;
import database.DBConnect;
import staff.Staff;

public class TestForAdmin {
	
	

	public  void AdminWorks() throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome Admin \n");
		System.out.println("Enter Admin Name : \n");
		String adminName = br.readLine();
		System.out.println("Enter Admin password : \n");
		String adminPassword = br.readLine();
		System.out.println("\n");
		
		List<Admin> admins = new ArrayList<Admin>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBConnect.startMySQLConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM admin";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Admin admin = new Admin();
				admin.setName(resultSet.getString("admin_name"));
				admin.setPassword(resultSet.getString("admin_password"));
				admins.add(admin);
				}
			
			for(int i=0; i< admins.size();i++) {
				try {
				if(adminName.equals(admins.get(i).getName()) && adminPassword.equals(admins.get(i).getPassword())) {
					Boolean exitAdmin = true;
					while(exitAdmin != false) {
						AdminDaoImpl implementAdmin = new AdminDaoImpl();
						System.out.println("Choose What you want to do : \n");
						System.out.println("0. \t Add Staff \n");
						System.out.println("1. \t Delete Staff \n");
						System.out.println("2. \t View all Staff \n");
						implementAdmin.viewAllStaff();
						System.out.println("3. \t Exit \n");
						
						int adminTask = Integer.parseInt(br.readLine());
						
						switch (adminTask) {
						case 0:
							System.out.println("Enter Staff Name : \n");
							String staffNameForAdd = br.readLine();
							System.out.println("Enter Staff password : \n");
							String staffPasswordForAdd = br.readLine();
							System.out.println("\n");
							
							implementAdmin.addStaff(staffNameForAdd, staffPasswordForAdd);
							break;
						case 1:
							System.out.println("Enter Staff Name : \n");
							String staffNameForDelete = br.readLine();
							implementAdmin.deleteStaff(staffNameForDelete);
							break;
						
						case 2:
							showStaff();
							break;
						case 3:
							exitAdmin = false;
							break;
						default:
							System.err.println("Choose valid task ");
						
						
						}
							
						
						
						
					}
					
				}else {
					System.err.println("You are not admin");
				}
				
			
			}catch(NumberFormatException numberFormat) {
				System.err.println(numberFormat);
			}
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
}


