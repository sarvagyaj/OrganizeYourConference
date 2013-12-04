package edu.sjsu.conference.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.DB;
 
@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {
  
 	@Override
    protected String getDatabaseName() {
		return "organize-your-conference";
    }

    @Override
    public Mongo mongo() throws Exception {
		
	// This code needs to be ENABLED for checking mongodb in mongolab[START]	

	 //connect to mongoDB (Mongolab AWS)
		MongoClient mongoClient = new MongoClient("ds051788.mongolab.com:51788" ); 
		DB database = mongoClient.getDB( "organize-your-conference" ); 
		boolean auth = database.authenticate("conference", "test123".toCharArray());
		
	// This code needs to be ENABLED for checking mongodb in mongolab[END]

	// This code needs to be DISABLED for checking mongodb in mongolab[START]	
	// Connect to mongodb (localhost)
		//MongoClient mongoClient = new MongoClient("localhost" ); 
	// This code needs to be DISABLED for checking mongodb in mongolab[END]

		return mongoClient;
    }
	
	
}