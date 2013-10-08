package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.sjsu.conference.domain.Participant;

@Controller
@RequestMapping("/registerParticipant")
//@SessionAttributes("participant")

public class registerParticipantController {
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
	        model.addAttribute("particpantFirstName", participant.getFirstName());
	        model.addAttribute("particpantLastName", participant.getLastName());
	        model.addAttribute("participantLocation", participant.getLocation());
			return "success";
	        
	    }
}
