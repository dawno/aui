package com.aui.web.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import org.bson.Document;

import com.aui.web.jdbc.JdbcConnection;
import com.aui.web.mongodb.MongoConnection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public  class Functions {

	public static Connection Connection(){
		JdbcConnection jd= new JdbcConnection();
		Connection con = null;
		try {
			 con=  jd.Connectio();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
	public  int userPresent(String user){
		String query=  "SELECT user_name FROM Information WHERE user_name = "+"'"+user+"'";

		Connection con=Connection();
		Statement stmt=null;


		try {
			 stmt= con.createStatement();
		
			int size=0;
			ResultSet rt= stmt.executeQuery(query);
			if(rt.next()){
				size++;
							}
			if(size<1){
				return 0;
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		return 1;
		
	}
	public int contactExist(String contact){
		String query=  "SELECT contact FROM Information WHERE contact = "+"'"+contact+"'";

		Connection con=Connection();
		Statement stmt=null;


		try {
			 stmt= con.createStatement();
		
			int size=0;
			ResultSet rt= stmt.executeQuery(query);
			if(rt.next()){
				size++;
							}
			if(size<1){
				return 0;
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		return 1;
		
	}
	public int checkPassword(String user, String oldPassword){
		String query=  "SELECT password FROM Information WHERE user_name = "+ "'"+user+"'";
		Statement stmt=null;
		ResultSet rs;
		try {
		rs=null;
			if(rs.next()){
				String pass= rs.getString("password");
				if(pass.equals(oldPassword)){
					return 1;
				}
				else{
					return 0;
			
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return 0;
	}
	public int userRegister(String first_name,String last_name,String user_name,String contact,String password,String address){
		int response=0;
		Connection con=Connection();
		Statement stmt=null;
		String query = " insert into Information (first_name, last_name, user_name, password, contact,address)"
		        + " values (?, ?, ?, ?,?,?);";

		java.sql.PreparedStatement preparedStmt=null;
		try {
			preparedStmt = con.prepareStatement(query);
		
			preparedStmt.setString (1, first_name);
		
			preparedStmt.setString (2, last_name);
		
			preparedStmt.setString   (3, user_name);
		
			preparedStmt.setString(4,password );
		
			preparedStmt.setString   (5, contact);
		    preparedStmt.setString(6, address);

		 response=	preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    MongoConnection connection = new MongoConnection();
	    MongoClient mongo= connection.mongoConnection();
	    MongoDatabase database = mongo.getDatabase("Office"); 
		MongoCollection<Document> collection = database.getCollection("Information");
		Document document = new Document("user_name", user_name) 
			      .append("first_name", first_name)
			      .append("second_name", last_name) 
			      .append("contact", contact) 
			      .append("address", address) 
			      .append("password", password);  
			      collection.insertOne(document); 
	   
		

	

	

		return response;
	}
	public void readUser(String user){
Connection con =  Connection();
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
	

		
MongoConnection connection = new MongoConnection();
MongoClient mongo= connection.mongoConnection();
MongoDatabase database = mongo.getDatabase("Office"); 
MongoCollection<Document> collection = database.getCollection("Information");
Document myDoc = collection.find( Filters.eq("user_name", user)).first();
	String firstName= myDoc.getString("first_name");
	String lastName= myDoc.getString("second_name");
	String addressName= myDoc.getString("address");
	String contactInfo = myDoc.getString("contact");
	

	}
	public int deleteUser(String user){
		int response=0;
		Connection con= Connection();
		String query = "DELETE FROM Information " +
                "WHERE user_name = "+"'"+user+"'";
Statement stmt=null;
		try {
			 stmt= con.createStatement();
		
		response=	stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 MongoConnection connection = new MongoConnection();
		    MongoClient mongo= connection.mongoConnection();
		    MongoDatabase database = mongo.getDatabase("Office"); 
			MongoCollection<Document> collection = database.getCollection("Information");
			collection.deleteOne(Filters.eq("user_name", user));
			return response;
	}
	public int updatePassword(String user,String newPassword){
		int response =0;
		Connection con= Connection();
		String query = "UPDATE Information " +
                "SET password ="+ "'"+newPassword+"'"+" WHERE user_name ="+"'"+user+"'";
		Statement stmt=null;


		try {
			 stmt= con.createStatement();
		
			 response = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
		
	
	}
	

