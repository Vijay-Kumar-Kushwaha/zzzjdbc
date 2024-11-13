package com.fetchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class GetData {
	private static final String query = "select * from employee";
	private static Connection con;
	private static ResultSet resultSet;
	private static Statement stmt;
	private static ResultSetMetaData rsmd;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/augustjdbc1", 
											  "root", "vijay123");
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);
			rsmd = resultSet.getMetaData();
			int count = rsmd.getColumnCount();
			for(int i = 1; i <= count; i++)	{
				System.out.println(rsmd.getColumnName(i)+" "+
									rsmd.getColumnTypeName(i));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
