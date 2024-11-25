package com.fetchdata;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoreProcInvo {
	
	
	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/company";
	private static String username = "root";
	private static String password = "vijay123";
	private static Scanner scan = new Scanner(System.in);
	private static CallableStatement collablestmt;
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		String sql = "{call emp_on_salary(?, ?)}";
		System.out.println("Enter the salary");
		int sal = scan.nextInt();
		
		collablestmt = con.prepareCall(sql); 
		collablestmt.setInt(1, sal);
		collablestmt.registerOutParameter(2, Types.INTEGER);
		collablestmt.execute();
		int count = collablestmt.getInt(2);
		System.out.println(count);
	}
}


















