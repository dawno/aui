package com.aui.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aui.web.jdbc.JdbcConnection;

/**
 * Servlet implementation class DeletionRegister
 */
public class DeletionRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletionRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String first=  request.getParameter("first");
		//String second = request.getParameter("last");
		String user = request.getParameter("user");
		//String contact= request.getParameter("contact");
	//	String address= request.getParameter("address");
	//	String password= request.getParameter("password");
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
		String query = "DELETE FROM Information " +
                "WHERE user_name = "+"'"+user+"'";
Statement stmt=null;
		try {
			 stmt= con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
