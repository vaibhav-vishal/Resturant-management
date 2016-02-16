package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Employee;
import com.training.ifaces.EmpDAO;
import com.training.util.SqlConnection;

public class EmployeeDAO implements EmpDAO<Employee> {
	private Connection con;

	public EmployeeDAO(Connection con) {
		super();
		this.con = con;
	}

	public EmployeeDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	@Override
	public int add(Employee t) {
		String sql = "insert into employeerecord values(?,?,?,?)";

		int rowadded = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getEmployeeId());
			pstmt.setString(2, t.getEmployeeName());
			pstmt.setLong(3, t.getPhoneNo());
			pstmt.setString(4, t.getDesignation());

			rowadded = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rowadded;
	}

	@Override
	public Employee find(int key) {
		Employee emp = null;
		String sql = "select * from employeerecord where employeeid=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = getEmployee(rs);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public List<Employee> findAll() {
		ArrayList<Employee> empList = new ArrayList<>();
		String sql = "Select * from employeerecord";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = getEmployee(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return empList;

	}

	private Employee getEmployee(ResultSet rs) {
		Employee emp = null;
		try {
			int empId = rs.getInt("");
			String empName = rs.getString("custName");
			String designation = rs.getString("email");
			long phone = rs.getLong("phone");

			emp = new Employee(empId, empName, phone, designation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int update(int key, long phone) {
		Employee emp = null;
		int rowupdated = 0;
		String sql = "update employeerecord set phonenumber=? where employeeId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, phone);
			pstmt.setInt(2, key);
			rowupdated = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowupdated;
	}

	@Override
	public int delete(int key) {
		int rowdeleted = 0;
		String sql = "delete from employeerecord where employeeId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowdeleted;
	}
}
