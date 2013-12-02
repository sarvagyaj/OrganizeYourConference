package edu.sjsu.conference.repository;

import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.conference.domain.Conference;
 
@Repository
public class ConferenceRepository {
     
    @Autowired
    MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "conference";

    public Conference findByFirstName(String firstName) { return null; }

    // Add a new conference
    public void addConference(Conference conference) {
        if (!mongoTemplate.collectionExists(COLLECTION_NAME/*Conference.class*/)) {
            mongoTemplate.createCollection(COLLECTION_NAME/*Conference.class*/);
        }       
        conference.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(conference, COLLECTION_NAME);
    }

    // List all the conferences 
    public List<Conference> listConference() {
        return mongoTemplate.findAll(Conference.class, COLLECTION_NAME);
    }

    // List all the conferences from current date 
    //for view all future conference 
    public List<Conference> listConferenceByDate() {
        
        Query dateQuery = new Query();
        dateQuery.addCriteria(Criteria.where("date").gte(GetCurrentDate()));
        try{
        List<Conference> confDetails;
        confDetails = mongoTemplate.find(dateQuery, Conference.class, COLLECTION_NAME);
        System.out.println("dateQuery - " + dateQuery.toString());
        System.out.println("confDetails - " + confDetails.size());
        for (int i=0;i<confDetails.size();i++)
            {
                System.out.println("Ramya - After dateQuery :"+confDetails.get(i));
            }
        return confDetails;
        }
        catch(Exception e){
        	System.out.println("Error While fetching data" + e.getMessage());
        	return null;
        }
        
    }

    // Get current Date
    private Date GetCurrentDate()
    {
        Date nDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
       //get current date time with Date()
       Date date = new Date();
       String currentDate = dateFormat.format(date);
       try{
            nDate = dateFormat.parse(currentDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("nDate = "+nDate);
        return (nDate);       
    }

    // Get the conference details based on id
    public Conference fetchConferenceById(String aId)
    {
        Query confQuery = new Query();
        confQuery.addCriteria(Criteria.where("id").is(aId));
 
        Conference conferenceDetail = mongoTemplate.findOne(confQuery, Conference.class, COLLECTION_NAME);
        System.out.println("confQuery - " + confQuery.toString());
        System.out.println("After confQuery :"+conferenceDetail);
           
        return conferenceDetail;
    }

    // Get all previous conference details of a organizer
    //TODO: Need to modify the way we would send the input parameter if required
    public List<Conference> getPreviousConferences(String aOrgnizer)
    {
        Query orgQuery = new Query();
        orgQuery.addCriteria(Criteria.where("organizer").is(aOrgnizer).and("date").lt(GetCurrentDate()));
 
        List<Conference> confDetailByOrganizer = mongoTemplate.find(orgQuery, Conference.class, COLLECTION_NAME);
        System.out.println("orgQuery - " + orgQuery.toString());
        System.out.println("confDetailByOrganizer - " + confDetailByOrganizer.size());
        for (int i=0;i<confDetailByOrganizer.size();i++)
        {
            System.out.println("After orgQuery :"+confDetailByOrganizer);
        }
           
        return confDetailByOrganizer;
    }

    // Get all registered conferences for a participant
    //TODO: Need to modify the way we would send the input parameter if required
    public List<Conference> getRegisteredConferences(String aParticipant)
    {
        String[] pName = aParticipant.split(" ");
        String aFirstName = pName[0];
        String aLastName = pName[1];

        Query parQuery = new Query();
        parQuery.addCriteria(Criteria.where("firstName").is(aFirstName).and("lastName").is(aLastName));
 
        List<Conference> confDetailByParticipants = mongoTemplate.find(parQuery, Conference.class, COLLECTION_NAME);
        System.out.println("parQuery - " + parQuery.toString());
        System.out.println("confDetailByParticipants - " + confDetailByParticipants.size());
        for (int i=0;i<confDetailByParticipants.size();i++)
        {
            System.out.println("After parQuery :"+confDetailByParticipants);
        }
           
        return confDetailByParticipants;
    }
     
    /*public void deleteConference(Conference conference) {
        mongoTemplate.remove(conference, COLLECTION_NAME);
    }*/
    // Delete the conference
    //TODO: Need to modify the input parameter if required
    public void deleteConference(String emailId) {
        mongoTemplate.remove(new Query(Criteria.where("emailId").is(emailId)), COLLECTION_NAME);
    }
     
     // Updates the fields
    public void updateConference(Conference conference) {
             
    }
}
