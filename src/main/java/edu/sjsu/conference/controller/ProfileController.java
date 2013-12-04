package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.UserRepository;

@Controller
@Scope("request")
@RequestMapping("/ProfilePage")
public class ProfileController {
	
			@Autowired
			private User user;
			@Autowired
			private UserRepository repository;
			
			protected static Logger log = Logger.getLogger("OrganizeYourConference");

			//View Profile
			@RequestMapping(method=RequestMethod.GET)
			public ModelAndView getProfile() {
				ModelAndView mv = new ModelAndView("ProfilePage");
				log.debug("email is :"+user.getEmailId()+" "+user.getFirstName());
				mv.addObject("user", user);
				return mv;
			}
			
			//Edit Profile
			@RequestMapping(method=RequestMethod.POST)
			public ModelAndView setProfile(@ModelAttribute("user") @Valid User changedUser,
					BindingResult result) {
				changedUser.setEmailId(user.getEmailId());
				changedUser.setRole(user.getRole());
				log.debug("users email id to update :" + user.getEmailId());
				User updatedUser=repository.updateUser(changedUser);
				
				//updating session object
				user.setUser(updatedUser);
				
				ModelAndView mv = new ModelAndView("ProfilePage");
				mv.addObject("user", updatedUser);
				return mv;
			}
			
}
