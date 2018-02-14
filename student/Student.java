package student;

public class Student {
	private int studentId;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	private String studentName;
	private String studentPassword;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public Student(String studentName, String studentPassword) {
		super();
		this.studentName = studentName;
		this.studentPassword = studentPassword;
	}
	public Student() {
		
	}
	
}
