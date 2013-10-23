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

import edu.sjsu.conference.domain.Participant;
import edu.sjsu.conference.repository.ParticipantRepository;
import edu.sjsu.conference.config.MongoConfig;

import com.mongodb.Mongo;
import java.util.List;


@Controller
@RequestMapping("/registerParticipant")
//@SessionAttributes("participant")

public class RegisterParticipantController {

		@Autowired
    	private ParticipantRepository participantRepository;
		
		protected static Logger log = Logger.getLogger("RegisterParticipantController");

		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(@ModelAttribute("participant") Participant participant1 , BindingResult participant) {
	        //model.addAttribute("user", new User());
	        return "registerParticipant"; 
		}

		//yet to be implemented fully
	    @RequestMapping(method = RequestMethod.POST)
	    public String registerParticipant( @ModelAttribute("participant") @Valid Participant participant, BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "registerParticipant";
	        }

	        //Code related to MongoDB [START]
	        log.debug("registerParticipant() : Participant = "+participant.toString());

	        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        	ParticipantRepository repository = context.getBean(ParticipantRepository.class);
	        
	        //Create collection and insert into it.
	        repository.addParticipant(participant);

	        // Display all the documents from the collection
	        List<Participant> part = repository.listParticipant();
	        for (int i=0;i<part.size();i++)
	        	System.out.println("Ramya firstname:"+part.get(i));

	        //Remove documents from the collection
	        //repository.deleteParticipant("l@l");

	        //Code related to MongoDB [END]

	        model.addAttribute("particpantFirstName", participant.getFirstName());
	        model.addAttribute("particpantLastName", participant.getLastName());
	        model.addAttribute("participantLocation", participant.getLocation());
    
			return "success";
	        
	    }
}
