package edu.sjsu.conference.repository;

import java.util.List;
import edu.sjsu.conference.domain.Speaker;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update; 
 
@Repository
public class SpeakerRepository {
     
    @Autowired
    MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "users";

    public void addSpeaker(Speaker speaker) {
        if (!mongoTemplate.collectionExists(/*Speaker.class*/COLLECTION_NAME)) {
            mongoTemplate.createCollection(/*Speaker.class*/COLLECTION_NAME);
        }       
        speaker.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(speaker, COLLECTION_NAME);
    }
     
    public List<Speaker> listSpeaker() {
        return mongoTemplate.findAll(Speaker.class, COLLECTION_NAME);
    }
     
    /*public void deleteSpeaker(Speaker speaker) {
        mongoTemplate.remove(speaker, COLLECTION_NAME);
    }*/
    public void deleteSpeaker(String emailId) {
        mongoTemplate.remove(new Query(Criteria.where("emailId").is(emailId)), COLLECTION_NAME);
    }
     
    public void updateSpeaker(Speaker speaker) {
        mongoTemplate.insert(speaker, COLLECTION_NAME);      
    }
}