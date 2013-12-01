package edu.sjsu.conference.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.User;

@Controller
@RequestMapping("/UserHome")
@Scope("request")
public class UserHomeController {

		@Autowired
		private User user;

		//Home of user, the page which he will he when he logs in
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView setupHome() {
			System.out.println("name is : "+  user.getFirstName());
			ModelAndView mv = new ModelAndView("UserHome");
			mv.addObject("user", user);
			return mv;
		}
		
		@RequestMapping("/{id}")		
		public void getConference(@PathVariable String id) {
			System.out.println("conference details for : "+  id);
			
		}
		
}
