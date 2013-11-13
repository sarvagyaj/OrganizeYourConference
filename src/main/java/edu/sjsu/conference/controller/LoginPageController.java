package edu.sjsu.conference.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.LoginPage;
 
@Controller
@RequestMapping("/LoginPage")


public class LoginPageController {

		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(@ModelAttribute("loginpage") LoginPage loginpage1 , BindingResult loginpage) {
	        
	        return "LoginPage"; 
		}

	    @RequestMapping(value="form", method = RequestMethod.POST)
	    public String LoginPage(@ModelAttribute("loginpage") @Valid LoginPage loginpage, BindingResult result, ModelMap model) {
	        
			if(loginpage.getType().equalsIgnoreCase("Organizer")){
				return "NewConference";
			}
			else if(loginpage.getType().equalsIgnoreCase("Participant")){
				return "registerParticipant";
			}
			else if(loginpage.getType().equalsIgnoreCase("Speaker")){
				return "SpeakerPage";
			}
			return "success";	
	        
	    }
	    
	    
}

