package edu.sjsu.conference.controller;

import javax.validation.Valid;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import edu.sjsu.conference.config.MongoConfig;
import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.Participant;
import edu.sjsu.conference.repository.ConferenceRepository;
 

@Controller
@RequestMapping("/NewConference")
//@SessionAttributes("participant")


public class ConferenceController {
		//Code related to MongoDB [START]
		@Autowired
		private ConferenceRepository conferenceRepository;

		protected static Logger log = Logger.getLogger("ConferenceController");
		//Code related to MongoDB [END]
		
		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(@ModelAttribute("conference") Conference conference, BindingResult result) {
	        return "NewConference"; 
	    }

		//yet to be implemented fully
	    @RequestMapping(method = RequestMethod.POST)

	    public String Conference( @ModelAttribute("conference") @Valid Conference conference, BindingResult result, ModelMap model) {
	        /*if (result.hasErrors()) {
	            return "success";
	        }*/
	        //Code related to MongoDB [START]
			log.debug("registerConference() : conference = "+conference.toString());

			AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
			ConferenceRepository repository = context.getBean(ConferenceRepository.class);

			//Create collection and insert into it.
			repository.addConference(conference);
			//Code related to MongoDB [END]
		
	        model.addAttribute("particpantFirstName", conference.gettopic());
	        model.addAttribute("particpantLastName", conference.getVenue());
	        model.addAttribute("desc", conference.getdescription());
			return "success1";
	    }
}
