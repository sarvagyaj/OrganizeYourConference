package edu.sjsu.conference.controller;

import javax.validation.Valid;

import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.apache.log4j.Logger;

import com.mongodb.Mongo;

import edu.sjsu.conference.config.MongoConfig;
import edu.sjsu.conference.domain.ProfilePage;
import edu.sjsu.conference.repository.ProfilePageRepo;

import java.util.List;


@Controller
@RequestMapping("/ProfilePage")
//@SessionAttributes("participant")

public class ProfilePageController {

		@Autowired
    	private ProfilePageRepo profilePageRepo;
		
		protected static Logger log = Logger.getLogger("RegisterParticipantController");

		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(@ModelAttribute("profilepage") ProfilePage profilePage1 , BindingResult profilePage) {
	        //model.addAttribute("user", new User());
	        return "ProfilePage"; 
		}

		//yet to be implemented fully
	    @RequestMapping(method = RequestMethod.POST)
	    public String registerParticipant( @ModelAttribute("profilepage") @Valid ProfilePage profilePage1, BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "ProfilePage";
	        }

	        //Code related to MongoDB [START]
	        log.debug("registerParticipant() : Participant = "+profilePage1.toString());

	        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        	ProfilePageRepo repository = context.getBean(ProfilePageRepo.class);
	        
	        //Create collection and insert into it.
	        repository.addParticipant(profilePage1);

	        // Display all the documents from the collection
	        List<ProfilePage> part = repository.listParticipant();
	        for (int i=0;i<part.size();i++)
	        	System.out.println("Ramya firstname:"+part.get(i));

	        //Remove documents from the collection
	        //repository.deleteParticipant("l@l");

	        //Code related to MongoDB [END]

	        model.addAttribute("particpantFirstName", profilePage1.getFirstName());
	        model.addAttribute("particpantLastName", profilePage1.getLastName());
	        model.addAttribute("participantLocation", profilePage1.getLocation());
    
			return "success";
	        
	    }
}
