package edu.sjsu.conference.repository;

import java.util.List;
import edu.sjsu.conference.domain.Participant;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update; 
 
@Repository
public class ParticipantRepository {
     
    @Autowired
    MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "users";

    public Participant findByFirstName(String firstName) { return null; }

    public void addParticipant(Participant participant) {
        if (!mongoTemplate.collectionExists(COLLECTION_NAME/*Participant.class*/)) {
            mongoTemplate.createCollection(COLLECTION_NAME/*Participant.class*/);
        }       
        participant.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(participant, COLLECTION_NAME);
    }
     
    public List<Participant> listParticipant() {
        return mongoTemplate.findAll(Participant.class, COLLECTION_NAME);
    }
     
    public void deleteParticipant(String emailId) {
        mongoTemplate.remove(new Query(Criteria.where("emailId").is(emailId)), COLLECTION_NAME);
    }
     
    public void updateParticipant(Participant participant) {
        mongoTemplate.insert(participant, COLLECTION_NAME);      
    }
}