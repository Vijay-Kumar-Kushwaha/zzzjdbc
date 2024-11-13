package com.fetchdata;

public class MyCredentials {
	private static String url = "jdbc:mysql://localhost:3306/augustjdbc";
	private static String username = "root";
	private static 	String password  = "vijay123";
	
	public static void setUrl(String url) {
		MyCredentials.url = url;
	}
	public static void setUsername(String username) {
		MyCredentials.username = username;
	}
	public static void setPassword(String password) {
		MyCredentials.password = password;
	}

	public static String getUrl() {
		return url;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
}
