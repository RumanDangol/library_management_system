package staff;

public class Staff {
	private int staffId;
	private String name;
	private String password;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Staff(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public Staff() {
		
	}
	
}
