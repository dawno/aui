package com.aui.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.*;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aui.web.jdbc.JdbcConnection;




public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first=  request.getParameter("first");
		String second = request.getParameter("last");
		String user = request.getParameter("user");
		String contact= request.getParameter("contact");
		String address= request.getParameter("address");
		String password= request.getParameter("password");
		//System.out.println(first);
		JdbcConnection jd= new JdbcConnection();
		Connection con = null;
		try {
			 con=  jd.Connectio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	String query = "update Information set last_name = ? where first_name = ?";
	  //  PreparedStatement preparedStmt = con.prepareStatement(query);
	   // preparedStmt.setString   (1, "singh");
	   // preparedStmt.setString(2, "utkarsh");
		String query = " insert into Information (first_name, last_name, user_name, password, contact,address)"
		        + " values (?, ?, ?, ?,?,?);";

		java.sql.PreparedStatement preparedStmt=null;
		try {
			preparedStmt = con.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			preparedStmt.setString (1, first);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			preparedStmt.setString (2, second);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			preparedStmt.setString   (3, user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			preparedStmt.setString(4,password );
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			preparedStmt.setString   (5, contact);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			preparedStmt.setString   (6, address);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    // execute the java preparedstatement
	    try {
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		

	}

	

}
