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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.UserRepository;

@Controller
@RequestMapping("/SignUp")
public class SignUpController {

	@Autowired
	private UserRepository repository;

	protected static Logger log = Logger.getLogger("SignUpController");

	@RequestMapping(method = RequestMethod.GET)
	public String setupRegistration(@ModelAttribute("user") @Valid User user,
			BindingResult result) {
		return "SignUp";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") @Valid User user,
			ModelMap model, BindingResult result) {

		log.debug("createUser : SignUpController = " + user.toString());
		// Create collection and insert into it.
		repository.addUser(user);

		model.addAttribute("particpantFirstName", user.getFirstName());
		model.addAttribute("particpantLastName", user.getLastName());
		model.addAttribute("desc", user.getEmailId());
		return "success1";
	}

	//API to check that userid entered which is used for logging in the system is not already present
	@RequestMapping("/checkUniqueEmail")
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
	}
}
