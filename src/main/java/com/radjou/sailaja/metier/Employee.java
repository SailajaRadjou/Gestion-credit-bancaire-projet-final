package com.radjou.sailaja.metier;

public class Employee {

	private int empId;
	private String userName;
	private String email;
	private String password;
	private int status;
	
	public Employee() {
		super();
	}

	public Employee(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", status=" + status + "]";
	}
	
	
	
}
