package com.fetchdata;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Authenticate {
	
	private static int pin = 121212;
	public static void verify(Scanner scan, Connection con) {
		System.out.println("Do you really want to send money?\nEnter pin");
		int upin = scan.nextInt();
		if(pin == upin) {
			System.out.println("inside if condition");
			try
			{
				con.commit();
				System.out.println("Committed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				con.rollback();
				System.out.println("Rollback");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
