package com.fetchdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchSpecificData {
	private static String query = "select * from student where id = ?";
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet resultSet;
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in);){
			//1 Load Driver 2.established connection		
			con = MyConnectionJdbc.myConnectJDBC();
			
			System.out.println("Enter  student id");
			
			int id = scan.nextInt();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+" "+
									resultSet.getString("name")+" "+						
									resultSet.getString("salary")+" "+						
									resultSet.getString("email")+" "+						
									resultSet.getString("dept")						
								  );
			}
			else {
				System.out.println("No record found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			MyConnectionJdbc.myCloseConnection(resultSet, pstmt, con);
		}
	}
}
