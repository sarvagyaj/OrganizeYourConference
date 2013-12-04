package edu.sjsu.conference.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.User;

@Repository
public class ConferenceRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	private UserRepository userRepository;

	public static final String COLLECTION_NAME = "conference";
	private static int idCounter = 0;
	protected static Logger log = Logger.getLogger("OrganizeYourConference");

	public Conference findByFirstName(String firstName) {
		return null;
	}

	// Add a new conference
	public void addConference(Conference conference) {
		if (!mongoTemplate
				.collectionExists(COLLECTION_NAME/* Conference.class */)) {
			mongoTemplate.createCollection(COLLECTION_NAME/* Conference.class */);
		}
		// conference.setId(UUID.randomUUID().toString());
		conference.setId(generateId());
		mongoTemplate.insert(conference, COLLECTION_NAME);
	}

	public synchronized int generateId() {
		int count = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			Query dateQuery = new Query();
			dateQuery.addCriteria(Criteria.where("id").gte(idCounter));
			List<Conference> confDetails = mongoTemplate.find(dateQuery,
					Conference.class, COLLECTION_NAME);

			if (confDetails.size() > 0)
				idCounter++;
			else {
				count = idCounter;
				break;
			}
		}
		return count;

    }

   /* public long generateId()
    {
        idCounter = new AtomicLong();
        long count = idCounter.getAndIncrement();
        System.out.println("counter = "+count);
        return (count);
    }*/

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
                System.out.println("After dateQuery :"+confDetails.get(i));
            }
        return confDetails;
        }
        catch(Exception e){
        	System.out.println("Error While fetching data" + e.getMessage());
        	return null;
        }
        
    }

	// Get current Date
	private Date GetCurrentDate() {
		Date nDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		// get current date time with Date()
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		try {
			nDate = dateFormat.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("nDate = " + nDate);
		return (nDate);
	}

	// Get the conference details based on id
	public Conference fetchConferenceById(Integer aId) {
		Query confQuery = new Query();
		confQuery.addCriteria(Criteria.where("id").is(aId));

		Conference conferenceDetail = mongoTemplate.findOne(confQuery,
				Conference.class, COLLECTION_NAME);
		System.out.println("confQuery - " + confQuery.toString());
		System.out.println("After confQuery :" + conferenceDetail);

		return conferenceDetail;
	}

	// Get all previous conference details of a organizer
	// TODO: Need to modify the way we would send the input parameter if
	// required
	// public List<Conference> getPreviousConferences(String aOrgnizer)
	public List<Conference> getPreviousConferences() {
		Query orgQuery = new Query();
		// orgQuery.addCriteria(Criteria.where("organizer").is(aOrgnizer).and("date").lt(GetCurrentDate()));
		orgQuery.addCriteria(Criteria.where("date").lt(GetCurrentDate()));
		List<Conference> confDetailByOrganizer = mongoTemplate.find(orgQuery,
				Conference.class, COLLECTION_NAME);
		System.out.println("orgQuery - " + orgQuery.toString());
		System.out.println("confDetailByOrganizer - "
				+ confDetailByOrganizer.size());
		for (int i = 0; i < confDetailByOrganizer.size(); i++) {
			System.out.println("After orgQuery :" + confDetailByOrganizer);
		}
		return confDetailByOrganizer;
	}

	// Get all registered conferences for a participant
	// TODO: Need to modify the way we would send the input parameter if
	// required
	public List<Conference> getRegisteredConferences(String aParticipant) {
		String[] pName = aParticipant.split(" ");
		String aFirstName = pName[0];
		String aLastName = pName[1];

		Query parQuery = new Query();
		parQuery.addCriteria(Criteria.where("firstName").is(aFirstName)
				.and("lastName").is(aLastName));

		List<Conference> confDetailByParticipants = mongoTemplate.find(
				parQuery, Conference.class, COLLECTION_NAME);
		System.out.println("parQuery - " + parQuery.toString());
		System.out.println("confDetailByParticipants - "
				+ confDetailByParticipants.size());
		for (int i = 0; i < confDetailByParticipants.size(); i++) {
			System.out.println("After parQuery :" + confDetailByParticipants);
		}
		return confDetailByParticipants;
	}

	/*
	 * public void deleteConference(Conference conference) {
	 * mongoTemplate.remove(conference, COLLECTION_NAME); }
	 */
	// Delete the conference
	// TODO: Need to modify the input parameter if required
	public void deleteConference(String emailId) {
		mongoTemplate.remove(new Query(Criteria.where("emailId").is(emailId)),
				COLLECTION_NAME);
	}

	// check whether the participant is present in the attendees of the
	// conference
	public boolean checkParticipant(int confID, String userEmailId) {
		Criteria c = new Criteria("id");
		c.is(confID);
		Query confQuery = new Query(c);
		confQuery.addCriteria(Criteria.where("attendees").is(userEmailId));
		Conference conferenceDetail = mongoTemplate.findOne(confQuery,
				Conference.class, COLLECTION_NAME);
		log.debug("query to chk participant present in the conference - "
				+ confQuery.toString());
		log.debug("result of chk participant query :" + conferenceDetail);
		if (conferenceDetail != null) {
			return true;
		} else {
			return false;
		}
	}

	public Conference addAttendees(int confID, String userEmailId) {
		Conference requestedConference = fetchConferenceById(confID);
		System.out.println("Received conf is : " + requestedConference);
		List<String> attendees = requestedConference.getAttendees();
		if(attendees != null)
			attendees.add(userEmailId);
		else{
			attendees = new ArrayList<String>();
			attendees.add(userEmailId);
		}
		requestedConference.setAttendees(attendees);
		mongoTemplate.save(requestedConference, COLLECTION_NAME);
		Conference savedConference = fetchConferenceById(confID);
		return savedConference;
	}

	public Conference removeAttendees(int confID, String userEmailId) {
		Conference requestedConference = fetchConferenceById(confID);
		System.out.println("Received conf is : " + requestedConference);
		List<String> attendees = requestedConference.getAttendees();
		attendees.remove(userEmailId);
		requestedConference.setAttendees(attendees);
		mongoTemplate.save(requestedConference, COLLECTION_NAME);
		Conference savedConference = fetchConferenceById(confID);
		return savedConference;
	}

	public Conference updateConference(Conference conference) {
		Conference requestedConference = fetchConferenceById(conference.getId());
		requestedConference.setConference(conference);
		mongoTemplate.save(requestedConference, COLLECTION_NAME);
		Conference updatedConference = fetchConferenceById(requestedConference
				.getId());
		return updatedConference;
	}

	public HashMap<String, String> getAttendees(int confID) {
		Conference requestedConference = fetchConferenceById(confID);
		List<String> attendees = requestedConference.getAttendees();
		HashMap<String, String> particpantList = new HashMap<String, String>();
		for (String email : attendees) {
			User user = userRepository.getUser(email, "Participant");
			//User user = userRepository.fetchUserByEmail("m@m");
			if(user!=null) {
			String name = user.getFirstName() + " " + user.getLastName();
			particpantList.put(email, name);}
			else {
				System.out.println("null participant obtained");
			}
		}
		return particpantList;
	}
	
	public List<Conference> getRegisteredConference(String userEmail){
		List<Conference> registeredConference = new ArrayList<Conference>();
		List<Conference> listConf = listConference();
		for(int i=0;i<listConf.size();i++){
			List<String> objAttendee = listConf.get(i).getAttendees();
			if(objAttendee != null && objAttendee.size() > 0){
			for(int j=0;j<objAttendee.size();j++){
				if(userEmail.equals(objAttendee.get(j).toString())){
					registeredConference.add(listConf.get(i));
				}
			}
			}
		}
		return registeredConference;
	}
	
}
