package edu.sjsu.conference.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.conference.domain.User;

@Repository
public class UserRepository {
	
	    @Autowired
	    MongoTemplate mongoTemplate;
	     
	    public static final String COLLECTION_NAME = "users";

	    public void addUser(User user) {
	        if (!mongoTemplate.collectionExists(COLLECTION_NAME/*Conference.class*/)) {
	            mongoTemplate.createCollection(COLLECTION_NAME/*Conference.class*/);
	        }       
	        user.setId(UUID.randomUUID().toString());
	        mongoTemplate.insert(user, COLLECTION_NAME);
	    }
	    
	    public long searchEmailID(String email) {
	    	Query query = new Query();
	    	Criteria c = new Criteria("emailId");
	    	c.is(email);
	    	query.addCriteria(c);
	    	System.out.println("Query is :" + query);
	    	long numberEmails = mongoTemplate.count(query, COLLECTION_NAME);
	    	return numberEmails;
	    }
	    
	    public User getUser(String email, String role) {
	    	Criteria criteria1 = new Criteria("emailId");
	    	criteria1.is(email);
	    	Criteria criteria2 = new Criteria("role");
	    	criteria2.is(role);
	    	Query query = new Query(criteria1);
	    	query.addCriteria(criteria2);
	    	System.out.println("Query is :" + query);
	    	
	    	User requestedUser = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
	    	System.out.println("query result is :" + requestedUser);
	    	if(requestedUser!=null) {
	    		return requestedUser;
	    	}
	    		return null; 
	    }
	    
	    public User updateUser(User user) {
	    	Criteria c = new Criteria("emailId");
	    	c.is(user.getEmailId());
	    	Query query = new Query(c);
	    	
	    	User requestedUser = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
	    	requestedUser.setUser(user);
	    	mongoTemplate.save(requestedUser,COLLECTION_NAME);
	    	System.out.println("query is : "+query);
	    	requestedUser = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
	    	return requestedUser;	    	
	    }
	     
}
