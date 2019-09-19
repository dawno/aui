package com.aui.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.aui.web.jdbc.JdbcConnection;
import com.aui.web.mongodb.MongoConnection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

/**
 * Servlet implementation class UpdateController
 */
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String first=  request.getParameter("first");
		//String second = request.getParameter("last");
		String user = request.getParameter("user");
	//	String contact= request.getParameter("contact");
		//String address= request.getParameter("address");
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
		String query = "UPDATE Information " +
                "SET password ="+ "'"+password+"'"+" WHERE user_name ="+"'"+user+"'";
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
		 MongoConnection connection = new MongoConnection();
		    MongoClient mongo= connection.mongoConnection();
		    MongoDatabase database = mongo.getDatabase("Office"); 
			MongoCollection<Document> collection = database.getCollection("Information");
			collection.updateOne(Filters.eq("user_name", user), Updates.set("password", password)); 
			
	}

	

}
