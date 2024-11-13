package com.fetchdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchData {
	static ResultSet res;
	static Connection con;
	static Statement stmt;
	public static void main(String[] args) {
		try
		{
			con = MyConnectionJdbc.myConnectJDBC();
			stmt = con.createStatement();
			String query = "SELECT * from student";
			res = stmt.executeQuery(query);
			System.out.println("Query executed");

			while(res.next() == true) {
				System.out.println
				(
						res.getInt("id")+" "+
						res.getString("name")+" "+
						res.getString("salary")+ " "+
						res.getString("email")+ " "+
						res.getString("dept")
				);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			MyConnectionJdbc.myCloseConnection(res, stmt, con);
		}
	}
}
