package com.fetchdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDetails {
	static Connection con;
	static PreparedStatement pstmt ;
	static private String query = "Insert into student (id, name, salary, email, dept)"
	+" values(?,?,?,?,?)";
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter Id of Student");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name of Student");
			String name = sc.nextLine();
			System.out.println("Enter Salary of Student");
			String salary = sc.nextLine();
			System.out.println("Enter email of Student");
			String email = sc.nextLine();
			System.out.println("Enter department of Student");
			String dept = sc.nextLine();
//			sc.close();
			//1. load the deriver
			//2. establish connection
			con = MyConnectionJdbc.myConnectJDBC();
			
			//3. incomplete query -> prepare the statement
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, salary);
			pstmt.setString(4, email);
			pstmt.setString(5, dept);
			
			int x = pstmt.executeUpdate();
			System.out.println(x+" row/s inserted");			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

//public class InsertDetails {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter your name");
//		String name = sc.nextLine();
//		System.out.println("Enter place name");
//		String place = sc.nextLine();
//		System.out.println("Enter email");
//		String email = sc.nextLine();
//		
//		System.out.println("name is: "+name+"\nplace is: "+place+"\nemail is: "
//				+ ""+email);
//		
//	}
//}