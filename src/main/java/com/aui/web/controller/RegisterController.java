package com.aui.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.*;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.aui.web.Interfaces.RegisterUser;
import com.aui.web.jdbc.JdbcConnection;
import com.aui.web.mongodb.MongoConnection;
import com.aui.web.util.Functions;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;




public class RegisterController extends HttpServlet implements RegisterUser {
	private static final long serialVersionUID = 1L;
    Functions fn= new Functions();
    public RegisterController() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		String first=  request.getParameter("first");
		String second = request.getParameter("last");
		String user = request.getParameter("user");
		String contact= request.getParameter("contact");
		String address= request.getParameter("address");
		String password= request.getParameter("password");
		if(userExist(user)==0){
			if(contactExist(contact)==0){
				registerUser(first,second,user,contact,password,address);
				msg="User Registered!";
			}
			else{
				msg= "Contact number already in use!!";
			}
		}
		else{
			msg="User already exists";
		}
				
		request.setAttribute("Message", msg);
		RequestDispatcher rd= request.getRequestDispatcher("message.jsp");
		rd.forward(request, response); 
	}

	public int userExist(String user) {
		
		return fn.userPresent(user);
	}

	public int contactExist(String contact) {
		// TODO Auto-generated method stub
		return fn.contactExist(contact);
	}

	public int registerUser(String first,String last,String user_name,String contact,String password,String address) {
		// TODO Auto-generated method stub
		
		fn.userRegister( first,last,user_name, contact, password,address);
		return 0;
	}

	

	

}
