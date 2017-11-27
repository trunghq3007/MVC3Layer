package cmc.data.model;

public class Student {
	int studentId;
	String fullName;
	String address;
	int age;
	
	public Student(int studentId, String fullName, String address, int age) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.address = address;
		this.age = age;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
