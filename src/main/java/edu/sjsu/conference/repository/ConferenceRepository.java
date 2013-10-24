package edu.sjsu.conference.repository;

import java.util.List;
import edu.sjsu.conference.domain.Conference;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update; 
 
@Repository
public class ConferenceRepository {
     
    @Autowired
    MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "conference";

    public Conference findByFirstName(String firstName) { return null; }

    public void addConference(Conference conference) {
        if (!mongoTemplate.collectionExists(COLLECTION_NAME/*Conference.class*/)) {
            mongoTemplate.createCollection(COLLECTION_NAME/*Conference.class*/);
        }       
        conference.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(conference, COLLECTION_NAME);
    }
     
    public List<Conference> listConference() {
        return mongoTemplate.findAll(Conference.class, COLLECTION_NAME);
    }
     
    /*public void deleteConference(Conference conference) {
        mongoTemplate.remove(conference, COLLECTION_NAME);
    }*/
    public void deleteConference(String emailId) {
        mongoTemplate.remove(new Query(Criteria.where("emailId").is(emailId)), COLLECTION_NAME);
    }
     
    public void updateConference(Conference conference) {
        mongoTemplate.insert(conference, COLLECTION_NAME);      
    }
}