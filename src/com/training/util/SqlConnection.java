package com.training.util;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class SqlConnection {

	public static Connection getOracleConnection() {

		Connection con = null;

		Properties prop = new Properties();

		try {
			FileInputStream instream = new FileInputStream("DbConnection.properties");
			prop.load(instream);
			Class.forName(prop.getProperty("db.className"));

			con = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.userName"),
					prop.getProperty("db.password"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
