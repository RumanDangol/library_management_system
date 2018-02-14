package admin;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import database.DBConnect;
import staff.Staff;

public  class AdminDaoImpl implements AdminDAO{

	@Override
	public void addStaff(String staffName, String staffPassword) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "INSERT INTO staff (staff_id, staff_name, staff_password)" +  "VALUES (NULL, ?, ?)";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, staffName);
			preparedstatement.setString(2, staffPassword);
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
	public void deleteStaff(String staffName) {
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "DELETE FROM staff WHERE staff.staff_name = ? ";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, staffName);
			
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
	public List<Staff> viewAllStaff() {
		List<Staff> staffs = new ArrayList<Staff>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBConnect.startMySQLConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM staff";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Staff staff = new Staff();
				staff.setName(resultSet.getString("staff_name"));
				staffs.add(staff);
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

		return staffs;
	}

	@Override
	public void updateStaff(String oldStaffName, String newStaffName, String newPassword) {
        
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try{
			
			connection = DBConnect.startMySQLConnection();
			
			String sql = "UPDATE staff SET " + "staff_name = ?, staff_password = ? WHERE staff_name = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, newStaffName);
			preparedstatement.setString(2, newPassword);
			preparedstatement.setString(3, oldStaffName);
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
		
	

}
