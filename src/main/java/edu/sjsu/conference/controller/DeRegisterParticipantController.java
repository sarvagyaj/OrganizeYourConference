package edu.sjsu.conference.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@RequestMapping("/DeRegisterConference")
@Scope("request")
public class DeRegisterParticipantController {
			@Autowired
			private User user;
		
			@Autowired
	    	private ConferenceRepository repository;
			
			protected static Logger log = Logger.getLogger("OrganizeYourConference");

			//delete the participant if he is registered for the conference
			@RequestMapping(value="/{id}",method = RequestMethod.GET)
		    public String deRegisterParticipant(@PathVariable("id") int id) {	
				String msg = "";
				if(!repository.checkParticipant(id, user.getEmailId())) {
					msg = "You have not registered for the conference yet.";
					System.out.println("You have not registered for the conference yet.");
					return "redirect:/ViewConference/"+id+"_"+msg;
				}
				Conference conference= repository.removeAttendees(id,user.getEmailId());
				if(conference != null) {
					msg = "You have been successfully deregistered from the conference ";
					System.out.println("User "+user.getEmailId()+" has been successfully deregistered from the conference " +id);
					return "redirect:/ViewConference/"+id+"_"+msg;		
				} else { 
					msg = "Due to some techincal issues, you cannot be deregistered from the system at the moment.";
					System.out.println("Due to some techincal issues, you cannot be deregistered from the system at the moment.");
					return "redirect:/ViewConference/"+id;					
				}
			}

}
