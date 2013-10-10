package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.Participant;
 

@Controller
@RequestMapping("/NewConference")
//@SessionAttributes("participant")


public class ConferenceController {
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
	        model.addAttribute("particpantFirstName", conference.gettopic());
	        model.addAttribute("particpantLastName", conference.getDate());
	        model.addAttribute("desc", conference.getdescription());
			return "success1";
	    }
}
