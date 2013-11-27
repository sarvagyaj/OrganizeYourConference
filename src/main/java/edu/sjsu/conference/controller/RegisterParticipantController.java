package edu.sjsu.conference.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.conference.domain.Participant;
import edu.sjsu.conference.repository.ParticipantRepository;


@Controller
@RequestMapping("/registerParticipant")
//@SessionAttributes("participant")

public class RegisterParticipantController {

		@Autowired
    	private ParticipantRepository repository;
		
		protected static Logger log = Logger.getLogger("RegisterParticipantController");

		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(@ModelAttribute("participant") Participant participant1 , BindingResult participant) {
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

	        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        	//ParticipantRepository repository = context.getBean(ParticipantRepository.class);
	        
	        //Create collection and insert into it.
	        repository.addParticipant(participant);

	        // Display all the documents from the collection
	        List<Participant> part = repository.listParticipant();

	        for (int i=0;i<part.size();i++) {
	        	System.out.println("All participant details:"+part.get(i));
	        }

	        //Code related to MongoDB [END]
	        
	        model.addAttribute("particpantFirstName", participant.getFirstName());
	        model.addAttribute("particpantLastName", participant.getLastName());
	        model.addAttribute("participantLocation", participant.getLocation());
    
			return "success";
	        
	    }
}
