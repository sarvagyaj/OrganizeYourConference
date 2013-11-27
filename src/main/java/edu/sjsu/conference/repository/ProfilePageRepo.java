package edu.sjsu.conference.repository;

import java.util.List;



import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import edu.sjsu.conference.domain.ProfilePage;
 
@Repository
public class ProfilePageRepo {
     
    @Autowired
    MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "users";

    public ProfilePage findByFirstName(String firstName) { return null; }

    public void addParticipant(ProfilePage profilepage) {
        if (!mongoTemplate.collectionExists(COLLECTION_NAME/*Participant.class*/)) {
            mongoTemplate.createCollection(COLLECTION_NAME/*Participant.class*/);
        }       
        profilepage.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(profilepage, COLLECTION_NAME);
    }
     
    public List<ProfilePage> listParticipant() {
        return mongoTemplate.findAll(ProfilePage.class, COLLECTION_NAME);
    }
     
    public void deleteParticipant(String emailId) {
        mongoTemplate.remove(new Query(Criteria.where("emailId").is(emailId)), COLLECTION_NAME);
    }
     
    public void updateParticipant(ProfilePage profilepage) {
        mongoTemplate.insert(profilepage, COLLECTION_NAME);      
    }
}