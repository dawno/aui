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

	public static void main(String[]args)throws Exception{
		/*MongoClient mongo = new MongoClient( "mongodb://<utkarsh>:<u1234567>@ds111178.mlab.com:11178/sky" ); 
		//MongoClient mongo= new MongoClient(serverAddresses, credentials);
		MongoDatabase database = mongo.getDatabase("sky"); 
		MongoCollection<Document> collection = database.getCollection("Information");
		BasicDBObject document = new BasicDBObject();
		document.put("first_name", "John");
		document.put("second_name", "Charlie");
		document.put("user_name", "Johnch");
		document.put("contact",12345 );
		((DBCollection) collection).insert(document);*/

	}
}
