package com.fetchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {
	static String query = "Delete from student where id = ?";
	private static Connection con;
	private static PreparedStatement pstmt;
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter id whose details you want to delete");
			int id = scan.nextInt();
			scan.close();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/augustjdbc",
											  "root", "vijay123");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			int x = pstmt.executeUpdate();
			System.out.println(x + " row/s deleted ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("pstmt and con closed");
		}
	}
}
