package com.fetchdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ModifyData {
	static String query="update student set name = ? where id = ?";
	static Connection con;
	static PreparedStatement pstmt;
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new student name");
			String name = sc.nextLine();
			System.out.println("Enter id of the student whose name you have changed");
			int id = sc.nextInt();
			sc.close();
			con = MyConnectionJdbc.myConnectJDBC();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			
			int x = pstmt.executeUpdate();
			System.out.println(x+" row/s updated");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			MyConnectionJdbc.myCloseConnection(null, pstmt, con);
		}
	}

}
