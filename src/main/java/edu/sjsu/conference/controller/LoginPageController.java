package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import edu.sjsu.conference.domain.LoginPage;
import edu.sjsu.conference.validator.LoginValidator;
 
@Controller
@RequestMapping("/LoginPage")

public class LoginPageController {
	
		LoginValidator loginValidator;
		@Autowired
		public LoginPageController(LoginValidator loginValidator){
			this.loginValidator = loginValidator;
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String processSubmit(
				@ModelAttribute("loginpage") LoginPage loginpage,
				BindingResult result, SessionStatus status) {
			
			loginValidator.validate(loginpage, result);
			
			if (result.hasErrors()) {
				//if validator failed
				return "LoginPage";
			} else {
				status.setComplete();
				//form success
				return "HomePage";
			}
		}

		@RequestMapping(method = RequestMethod.GET)
		public String initForm(ModelMap model){
			
			LoginPage loginpage = new LoginPage();
			model.addAttribute("loginpage", loginpage);
	 		return "LoginPage";
		}
	 
		
	   /* @RequestMapping(value="form", method = RequestMethod.POST)
	    public String LoginPage(@ModelAttribute("loginpage") @Valid LoginPage loginpage, BindingResult result, ModelMap model) {
	    	System.out.println("I am in LoginPage");
	        
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
	        
	    }*/
	    
	    
}

