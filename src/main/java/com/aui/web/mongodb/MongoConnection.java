package com.aui.web.mongodb;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 
import java.util.Iterator; 
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  
public class MongoConnection {

	
	public static MongoClient mongoConnection(){
		MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		
				
		return mongo;
		
	}
}
