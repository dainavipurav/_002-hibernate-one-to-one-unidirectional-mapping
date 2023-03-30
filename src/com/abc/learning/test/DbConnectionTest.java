package com.abc.learning.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionTest {
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_mapping_ont_to_one?useSSL=false";
		String userName = "root";
		String password = "root";
		
		Connection con = null;
		
		try {
			con =  DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection established successfully");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection not established");
		}
	}
}
