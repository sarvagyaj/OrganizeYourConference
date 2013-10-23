package edu.sjsu.conference.config;

import java.util.Arrays;

import edu.sjsu.conference.repository.ParticipantRepository;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.authentication.UserCredentials;
 
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.*;
 
@Configuration
@EnableMongoRepositories
@ComponentScan({"edu.sjsu.conference"})
public class MongoConfig extends AbstractMongoConfiguration {
  
 	@Override
    protected String getDatabaseName() {
		return "organize-your-conference";
    }

    @Override
    public Mongo mongo() throws Exception {
		
	 //connect to mongoDB
		MongoClient mongoClient = new MongoClient("ds051788.mongolab.com:51788" ); 
		DB database = mongoClient.getDB( "organize-your-conference" ); 
		boolean auth = database.authenticate("conference", "test123".toCharArray());
		
		return mongoClient;
    }
	
	
}