package edu.sjsu.conference.repository;

import java.util.List;
import edu.sjsu.conference.domain.Organiser;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
 
@Repository
public class OrganizerRepository {
     
    @Autowired
    MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "users";

    public void addOrganizer(Organiser organizer) {
        if (!mongoTemplate.collectionExists(Organiser.class)) {
            mongoTemplate.createCollection(Organiser.class);
        }       
        organizer.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(organizer, COLLECTION_NAME);
    }
     
    public List<Organiser> listOrganizer() {
        return mongoTemplate.findAll(Organiser.class, COLLECTION_NAME);
    }
     
    public void deleteOrganizer(/*Organiser organizer*/) {
        
    }
     
    public void updateOrgnizer(Organiser organizer) {
        
    }
}