package admin;

import java.util.List;

import staff.Staff;

public abstract interface AdminDAO {
	public void addStaff(String staffName, String staffPassword);
	public void deleteStaff(String staffName);
	List<Staff> viewAllStaff();
	public void updateStaff(String oldStaffName, String newStaffName, String newPassword);
}
