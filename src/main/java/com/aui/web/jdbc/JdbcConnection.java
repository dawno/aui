package com.aui.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class JdbcConnection {
	public static void main(String[]args)throws Exception{
		String url= "jdbc:mysql://localhost:3306/Office";
		String uname="";
		String  password= "";
		//String query= "SELECT user_name  from Information WHERE first_name = 'utkarsh'";
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/Office","root",""); 
	String query = "update Information set last_name = ? where first_name = ?";
    PreparedStatement preparedStmt = con.prepareStatement(query);
    preparedStmt.setString   (1, "sachin");
    preparedStmt.setString(2, "utkarsh");

    // execute the java preparedstatement
    preparedStmt.executeUpdate();
	}
}
