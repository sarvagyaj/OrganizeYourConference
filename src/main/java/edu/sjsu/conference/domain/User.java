package edu.sjsu.conference.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * @author saru
 *
 */
@Component
@Scope("session")
public class User implements Serializable {
	
	@Id
	protected String id;

	protected String firstName,lastName,role;
	protected String emailId;
	protected String password;
	protected String confirmPassword;
	protected String location;
	//protected List<Long> conferenceID;
	protected String position;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getLastName() {
		return lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	/*public List<Long> getConferenceID() {
		return conferenceID;
	}
	public void setConferenceID(List<Long> conferenceID) {
		this.conferenceID = conferenceID;
	}*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	//the method copies the attributes of 'user' to called Object's attributes 
	//our website does not provide the functionality of changing the role and emailID
	public void setUser(User user) {
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setEmailId(user.getEmailId());
		this.setPassword(user.getPassword());
		this.setLocation(user.getLocation());
		this.setRole(user.getRole());					
		this.setPosition(user.getPosition());
	}
	
	@Override
    public String toString() {
        return String.format(
                "User [firstName = %s, lastName = '%s', emailId = '%s', " + 
                "location = '%s', role = '%s', position = '%s']",
                firstName, lastName, emailId, location, role, position);
    }
	
}
