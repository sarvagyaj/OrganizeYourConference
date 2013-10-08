package edu.sjsu.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registerParticipant")
//@SessionAttributes("participantName")
public class registerParticipantController {
		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(ModelMap model) {
	        //model.addAttribute("user", new User());
	        return "registerParticipant"; 
	    }

		//yet to be implemented fully
	    /**@RequestMapping(method = RequestMethod.POST)
	    public String registerParticipant( @ModelAttribute("participant") @Valid Participant participant, BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "registerParticipant";
	        }
	        model.addAttribute("particpantName", participant.getName());
			return "success";
	        
	    }*/
}
