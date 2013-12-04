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
@RequestMapping("/ViewAllPreviousConference")
@Scope("request")
public class ViewPrevious {

		@Autowired
		private User user;
		
		@Autowired
		ConferenceRepository objConferenceRepo;

		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView setupHome() {
			ModelAndView mv = new ModelAndView("ViewAllPreviousConference");
			mv.addObject("user", user);
			List<Conference> conf = new ArrayList< Conference >();
			conf.addAll(getConference());  
			mv.addObject("confer", conf); 
			return mv;
		}
		
		public List<Conference> getConference() {		
			List<Conference> lstConference = objConferenceRepo.getPreviousConferences();			
			return lstConference;			
		}
	
}

