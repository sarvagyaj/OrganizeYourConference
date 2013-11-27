package edu.sjsu.conference.domain;

import edu.sjsu.conference.domain.User;


public class ProfilePage extends User {
	
	public void validateUser()
	{
		
	}
	public void getProfile()
	{
	
	}

	@Override
    public String toString() {
        return String.format(
                "ProfilePage [id = %s, firstName = '%s', lastName = '%s', " + 
                "location = '%s', role = '%s', emailId = '%s', conferenceID = '%s']",
                id, firstName, lastName, location, role, emailId, conferenceID);
    }
}
