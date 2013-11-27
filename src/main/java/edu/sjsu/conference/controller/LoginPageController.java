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

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.UserRepository;

@Controller
@Scope("request")
@RequestMapping("/LoginPage")
public class LoginPageController {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private User user;

	@RequestMapping(method = RequestMethod.GET)
	public String setupLogin(
			@ModelAttribute("loginpage") User user,
			BindingResult loginpage) {
		return "LoginPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String SignIn(@ModelAttribute("loginpage") @Valid User loggedUser,
			BindingResult result, ModelMap model) {
		User newUser = repository.getUser(loggedUser.getEmailId(),
				loggedUser.getRole());
		
		if (newUser!=null && loggedUser.getPassword().equals(newUser.getPassword())) {
			System.out.println("correct password");
			
			//setting session object "user"
			user.setUser(newUser);
			
			if (loggedUser.getRole().equalsIgnoreCase("Organizer")) {
				return "redirect:/UserHome";
			} else if (loggedUser.getRole().equalsIgnoreCase("Participant")) {
				return "redirect:/UserHome";
			} else if (loggedUser.getRole().equalsIgnoreCase("Speaker")) {
				return "redirect:/UserHome";
			}
			return "success";
		} else {
			System.out.println("Incorrect username/password");
			return "LoginPage";
		}

	}
}
