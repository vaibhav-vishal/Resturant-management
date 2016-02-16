package com.training.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.training.util.SqlConnection;

public class ValidateEmployee {
	private Connection con;

	public boolean validate(Employee emp) {
		
		
		String sql = "Select * from UserInfo where username=? AND password=?";
		ResultSet rs = null;
		boolean check = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getUsername());
			pstmt.setString(2, emp.getPassword());
			rs = pstmt.executeQuery();
			check = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	 public ValidateEmployee() {
			super();
		con = SqlConnection.getOracleConnection();
	}
}
