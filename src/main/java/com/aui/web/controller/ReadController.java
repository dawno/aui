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

import org.bson.Document;

import com.aui.web.Interfaces.ReadInterface;
import com.aui.web.jdbc.JdbcConnection;
import com.aui.web.models.User;
import com.aui.web.mongodb.MongoConnection;
import com.aui.web.util.Functions;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class ReadController extends HttpServlet implements ReadInterface {
	private static final long serialVersionUID = 1L;
       Functions fn= new Functions();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg= "User does not exist!!";
				String user = request.getParameter("user");
				if(userExist(user)==1){
					readUser(user,request,response);
				}
				else{
					request.setAttribute("Message", msg);
					RequestDispatcher rd= request.getRequestDispatcher("message.jsp");
					rd.forward(request, response); 
				}
			
	}


	public int userExist(String user) {
		return fn.userPresent(user);
	}


	public void readUser(String user,HttpServletRequest request,HttpServletResponse response) {
		
		fn.readUser(user, request,response);
	}

	

}
