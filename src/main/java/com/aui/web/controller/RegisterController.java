package com.aui.web.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aui.web.jdbc.JdbcConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



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
		String second = request.getParameter("second");
		String user = request.getParameter("user");
		String contact= request.getParameter("contact");
		String address= request.getParameter("address");
		String password= request.getParameter("password");
		//System.out.println(first);
		JdbcConnection jd= new JdbcConnection();
		try {
			java.sql.Connection con=  jd.Connectio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	String query = "update Information set last_name = ? where first_name = ?";
	  //  PreparedStatement preparedStmt = con.prepareStatement(query);
	   // preparedStmt.setString   (1, "singh");
	   // preparedStmt.setString(2, "utkarsh");
		Statement statement = con.createStatement();
	    // execute the java preparedstatement
	   // preparedStmt.executeUpdate();
		statement.executeUpdate("INSERT INTO Information " + "VALUES (first, last, user_name, password, contact,address)");

	}

	

}
