package com.fetchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnectionJdbc {
	static Connection con;
	public static Connection myConnectJDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			
			con = DriverManager.getConnection(MyCredentials.getUrl(), MyCredentials.getUsername(), MyCredentials.getPassword());
			System.out.println("Connection Established");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void myCloseConnection(ResultSet res, Statement stmt, Connection con) {
		try {
			if(res!= null)	{
				res.close();
				System.out.println("Resultset closed successfully");
			}
			if(stmt != null) {
				stmt.close();
				System.out.println("Statement closed successfully");
			}
			if(con != null) {
				con.close();
				System.out.println("connection closed successfully");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
