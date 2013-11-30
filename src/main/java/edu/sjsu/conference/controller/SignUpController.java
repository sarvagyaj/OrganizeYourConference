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

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.UserRepository;
import edu.sjsu.conference.validator.SignUpValidator;

@Controller
@RequestMapping("/SignUp")
public class SignUpController {
	
	SignUpValidator signupValidator;

	@Autowired
	private UserRepository repository;
	
	@Autowired
	public SignUpController(SignUpValidator signupValidator){
		this.signupValidator = signupValidator;
	}
	protected static Logger log = Logger.getLogger("SignUpController");

	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){		
		User user = new User();
		model.addAttribute("user", user);
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
			// Create collection and insert into it.
			repository.addUser(newUser);
			
			//form success
			return "UserHome";
		}

	}

	//API to check that userid entered which is used for logging in the system is not already present
	/*@RequestMapping("/checkUniqueEmail")
	public @ResponseBody
	boolean checkUniqueEmail(@RequestParam("emailID") String emailID) {
		long countEmails = repository.searchEmailID(emailID);
		if (countEmails > 0) {
			System.out.println("emailID alreay present");
			return true;
		} else {
			System.out.println("Given emailID can be used as a new email id");
			return false;
		}
	}*/
}
