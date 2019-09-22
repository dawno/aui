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

import com.aui.web.Interfaces.UpdationInterface;
import com.aui.web.jdbc.JdbcConnection;
import com.aui.web.mongodb.MongoConnection;
import com.aui.web.util.Functions;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


public class UpdateController extends HttpServlet implements UpdationInterface {
	private static final long serialVersionUID = 1L;
    Functions fn=new Functions();
    public UpdateController() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String msg="";
		String user = request.getParameter("user");
	String oldPassword = request.getParameter("oldPassword");
		String password= request.getParameter("newPassword");
		if(userExist(user)==1){
			if(passwordMatch(user,oldPassword)==1){
				updatePassword(user,password);
				msg="password updated";
			}else{
				msg="password did not match";
			}
		}else{
			msg="user does not exist";
		}
		request.setAttribute("Message", msg);
		RequestDispatcher rd= request.getRequestDispatcher("message.jsp");
		rd.forward(request, response); 
		
			}


	public int userExist(String user) {
		
		return fn.userPresent(user);
	}


	public int passwordMatch(String user, String oldPassword) {
		
		return fn.checkPassword(user,oldPassword);
	}


	public int updatePassword(String user, String newPassword) {
		// TODO Auto-generated method stub
		return fn.checkPassword(user, newPassword);
	}

	

}
