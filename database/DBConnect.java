package database;

import java.sql.Connection;
import java.sql.DriverManager;




public  class DBConnect {
	

		
		public static final String urlForMySQL = "jdbc:mysql://localhost:3306/";
		public static final String dbName = "library_management";
		
		public static final String name = "root";
		public static final String driver = "com.mysql.jdbc.Driver";
		public static final String password = "";
		public static Connection startMySQLConnection() {
			Connection connection = null;
			try {
			Class.forName(driver);
			connection = DriverManager.getConnection(urlForMySQL+dbName, name, password); 
			System.out.println("Database Connected");
			
			
			}catch(Exception e) {
			System.out.println("Not connected");
		}
			return connection;
		}
		
	

}
