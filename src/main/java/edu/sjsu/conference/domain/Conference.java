package edu.sjsu.conference.domain;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Conference {
	private int id;
	private String topic;
	private String description;
	private Date date;
	private String time;
	private String venue;
	private String speaker_name;
	private String speaker_link;
	private String speaker_email;
	//private List<Conference> conference;
	private List<String> invitedParticipantsList;
	private String participants;
	private List<String> attendees;
	
	public Conference()
	{
		
	}

	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	/*public List<Conference> getConference() {
		return conference;
	}

	public void setConference(List<Conference> conference) {
		this.conference = conference;
	}*/

	public String getSpeaker() {
		return speaker_name;
	}

	public void setSpeaker(String speaker) {
		this.speaker_name = speaker;
	}

	public String getSpeaker_name() {
		return speaker_name;
	}

	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}

	public String getSpeaker_link() {
		return speaker_link;
	}

	public void setSpeaker_link(String speaker_link) {
		this.speaker_link = speaker_link;
	}

	public String getSpeaker_email() {
		return speaker_email;
	}

	public void setSpeaker_email(String speaker_email) {
		this.speaker_email = speaker_email;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getParticipants() {
		return participants;
	}

	public List<String> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}

	public List<String> getInvitedParticipantsList() {
		return invitedParticipantsList;
	}

	public void setInvitedParticipantsList(List<String> invitedParticipantsList) {
		this.invitedParticipantsList = invitedParticipantsList;
	}

	@Override
    public String toString() {
        return String.format(
                "Conference [id = %s, date = '%s', time = '%s', " + 
                "venue = '%s', topic = '%s', description = '%s', speaker = '%s', participants='%s']",
                id, date, time, venue, topic, description, speaker_name, participants);
    }

}
