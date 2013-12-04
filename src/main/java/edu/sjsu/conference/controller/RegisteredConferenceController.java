package edu.sjsu.conference.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@RequestMapping("/RegisteredConference")
@Scope("request")
public class RegisteredConferenceController {

		@Autowired
		private User user;
		
		@Autowired
		ConferenceRepository objConferenceRepo;

		//Home of user, the page which he will he when he logs in
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView setupHome() {
			ModelAndView mv = new ModelAndView("RegisteredConference");
			mv.addObject("user", user);			
			List<Conference> conf = new ArrayList< Conference >();
			conf.addAll(getRegisteredConference(user.getEmailId()));  
			if(conf != null)
				mv.addObject("confer", conf);			
			return mv;
		}
		
	
		public List<Conference> getRegisteredConference(String useremail) {	
			List<Conference> lstConference = objConferenceRepo.getRegisteredConference(useremail);		
			return lstConference;			
		}
	
}

