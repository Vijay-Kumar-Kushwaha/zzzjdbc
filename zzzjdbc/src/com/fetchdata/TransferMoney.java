/*
 * table name user
 * it has 4 column
 * id int
 * accno String
 * name String
 * bal String
 * */
package com.fetchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransferMoney {
	
	private static final String DISP = "SELECT * from `user`";
	private static final String S_AMOUNT = "update user set "
			+ "bal = bal-? where accno = ?";
	private static final String R_AMOUNT = "update user set "
			+ "bal = bal+? where accno = ?";
	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/bank";
	private static String username = "root";
	private static String password = "vijay123";
	private static Statement stmt;
	private static ResultSet resultSet;
	private static Scanner scan = new Scanner(System.in);
	private static PreparedStatement pstmt;
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		disp();
		try {
			con.setAutoCommit(false);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(); 
		System.out.println("Enter the sender's account number");
		String amount = null;
		try {
			String saccno = scan.next();
			System.out.println("Enter the amount ");
			 amount = scan.next();
			pstmt = con.prepareStatement(S_AMOUNT);
			pstmt.setString(1, amount);
			pstmt.setString(2, saccno);
			int x = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter the receiver's account number");
		String raccno = scan.next();
		try {
			pstmt = con.prepareStatement(R_AMOUNT);
			pstmt.setString(1, amount);
			pstmt.setString(2, raccno);
			
			int x = pstmt.executeUpdate();
			if(x==0)
				System.out.println("Failure");
			else
				System.out.println("Success");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disp();
		
	}
	
	
	static void disp() {
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(DISP);
			while(resultSet.next())	{
				System.out.println(	resultSet.getInt(1)+" "+
							resultSet.getString(2)+" "+
							resultSet.getString(3)+" "+
							resultSet.getString(4));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
