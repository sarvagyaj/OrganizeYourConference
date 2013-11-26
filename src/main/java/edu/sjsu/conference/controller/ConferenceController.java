package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.repository.ConferenceRepository;
 

@Controller
@RequestMapping("/NewConference")
public class ConferenceController {

		@Autowired
		private ConferenceRepository repository;

		protected static Logger log = Logger.getLogger("ConferenceController");
		
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


			//Create collection and insert into it.
			repository.addConference(conference);
			//Code related to MongoDB [END]
		
	        model.addAttribute("particpantFirstName", conference.gettopic());
	        model.addAttribute("particpantLastName", conference.getVenue());
	        model.addAttribute("desc", conference.getdescription());
			return "success1";
	    }
}
