package edu.sjsu.conference.domain;

import java.util.List;

public class User {
	protected String name;
	protected long id;
	protected String emailID;
	protected String location;
	protected List<Long> conferenceID;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Long> getConferenceID() {
		return conferenceID;
	}
	public void setConferenceID(List<Long> conferenceID) {
		this.conferenceID = conferenceID;
	}

	
	//public void getProfile();
	//public void validateUser();
	
	
}
