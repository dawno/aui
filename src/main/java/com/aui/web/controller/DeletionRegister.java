package com.aui.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.aui.web.Interfaces.DeletionInterface;
import com.aui.web.jdbc.JdbcConnection;
import com.aui.web.mongodb.MongoConnection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.aui.web.util.Functions;

public class DeletionRegister extends HttpServlet implements DeletionInterface {
	private static final long serialVersionUID = 1L;
       Functions fn = new Functions();
   
    public DeletionRegister() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg= "";
		String user = request.getParameter("user");
		if(userExist(user)==1){
			if(deleteUser(user)==1){
				 msg= "User deleted!!";
				
			}
			else{
			 msg= "User did not deleted";
				}
		}
		else{
		 	msg= "User not registered!!";
			
		}
		request.setAttribute("Message", msg);
		RequestDispatcher rd= request.getRequestDispatcher("message.jsp");
		rd.forward(request, response); 
		
	}


	public int userExist(String user) {
		return fn.userPresent(user);
		
	}


	public int deleteUser(String user) {
		// TODO Auto-generated method stub
		return fn.deleteUser(user);
		
	}


	

	

}
