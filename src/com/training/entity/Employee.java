package com.training.entity;

public class Employee {
private int EmployeeId;
private String EmployeeName;
private long PhoneNo;
private String Designation;
private String username;
private String password;
private String role;

public Employee(int employeeId, String employeeName, long phoneNo, String designation) {
	super();
	EmployeeId = employeeId;
	EmployeeName = employeeName;
	PhoneNo = phoneNo;
	Designation = designation;
}



public Employee(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}



public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Employee() {
	super();
	
}

public int getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
}
public String getEmployeeName() {
	return EmployeeName;
}
public void setEmployeeName(String employeeName) {
	EmployeeName = employeeName;
}
public long getPhoneNo() {
	return PhoneNo;
}
public void setPhoneNo(long phoneNo) {
	PhoneNo = phoneNo;
}
public String getDesignation() {
	return Designation;
}
public void setDesignation(String designation) {
	Designation = designation;
}
@Override
public String toString() {
	return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", PhoneNo=" + PhoneNo
			+ ", Designation=" + Designation + "]";
}


}
