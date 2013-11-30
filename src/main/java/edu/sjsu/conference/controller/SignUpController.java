package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.UserRepository;
import edu.sjsu.conference.validator.SignUpValidator;

@Controller
@Scope("request")
@RequestMapping("/SignUp")
public class SignUpController {
	
	SignUpValidator signupValidator;

	@Autowired
	private User user;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	public SignUpController(SignUpValidator signupValidator){
		this.signupValidator = signupValidator;
	}
	protected static Logger log = Logger.getLogger("SignUpController");

	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){		
		User newUser = new User();
		model.addAttribute("user", newUser);
 		return "SignUp";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") @Valid User newUser,
			ModelMap model, BindingResult result) {
		
		log.debug("createUser : SignUpController = " + newUser.toString());
		signupValidator.validate(newUser, result);
		
		if (result.hasErrors()) {
			//if validator failed
			return "SignUp";
		} else {			
			repository.addUser(newUser);		// Create collection and insert into it.
			user.setUser(newUser);				//setting session object
			return "UserHome";					//form success
		}
	}
	
}
