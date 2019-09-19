package com.aui.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aui.web.jdbc.JdbcConnection;
import com.aui.web.models.User;


public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadController() {
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
				String query = "SELECT first_name, last_name, address, contact FROM Information WHERE user_name = "+"'" +user+"'";
		Statement stmt=null;
		ResultSet rs=null;
		String first=null;
		String last=null;
		String address=null;
		String contact=null;
				try {
					 stmt= con.createStatement();
				
				 rs	= stmt.executeQuery(query);
				if(rs.next()){
				 first= rs.getString("first_name");
				
				 last= rs.getString("last_name");
				
				 contact= rs.getString("contact");
				
					 address = rs.getString("address");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			/*	User u= new User();
				u.setFirst(first);
				u.setSecond(last);
				u.setAddress(address);
				u.setContact(contact); */
request.setAttribute("first_name", first);
request.setAttribute("last_name", last);
request.setAttribute("contact", contact);
request.setAttribute("address",address);  
				//request.setAttribute("UserObject", u);

			
RequestDispatcher rd= request.getRequestDispatcher("show.jsp");
rd.forward(request, response);

	}

	

}
