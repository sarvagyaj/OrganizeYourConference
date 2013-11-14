package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HttpServletBean;

import edu.sjsu.conference.domain.LoginPage;
 

@Controller
@RequestMapping("/LoginPage")
//@SessionAttributes("participant")


public class LoginPageController {
		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(@ModelAttribute("loginpage") LoginPage loginpage1 , BindingResult loginpage) {
	        return "LoginPage"; 
	    }

	    @RequestMapping(method = RequestMethod.POST)
	    public String LoginPage(@ModelAttribute("loginpage") @Valid LoginPage loginpage, BindingResult result, ModelMap model) {
	        
			if(loginpage.gettype().equalsIgnoreCase("Organizer")){
				return "NewConference";
			}
			else if(loginpage.gettype().equalsIgnoreCase("Participant")){
				return "registerParticipant";
			}
			else if(loginpage.gettype().equalsIgnoreCase("Speaker")){
				return "SpeakerPage";
			}
			return "success";	
	        
	    }
	    
	    
}

