package com.aui.web.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;




public class JdbcConnection {
	public static Connection Connectio ()throws Exception{
		String url= "jdbc:mysql://localhost:3306/Office";
		
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con= DriverManager.getConnection(url,"root",""); 
	
	return con;
	}
	public static void main(String[]args){
		 try {
			Connectio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
