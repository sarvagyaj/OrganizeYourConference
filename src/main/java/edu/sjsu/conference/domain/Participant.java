package edu.sjsu.conference.domain;

public class Participant extends User {
	
	public void validateUser()
	{
		
	}
	public void getProfile()
	{
	
	}

	@Override
    public String toString() {
        return String.format(
                "Participant [id = %s, firstName = '%s', lastName = '%s', " + 
                "location = '%s', role = '%s', emailId = '%s', conferenceID = '%s']",
                id, firstName, lastName, location, role, emailId, conferenceID);
    }
}
