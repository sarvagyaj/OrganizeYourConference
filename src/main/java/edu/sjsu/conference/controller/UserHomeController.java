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
@RequestMapping("/UserHome")
@Scope("request")
public class UserHomeController {

		@Autowired
		private User user;
		
		@Autowired
		ConferenceRepository objConferenceRepo;

		//Home of user, the page which he will he when he logs in
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView setupHome() {
			System.out.println("name is : "+  user.getFirstName());
			ModelAndView mv = new ModelAndView("UserHome");
			mv.addObject("user", user);
			List<Conference> conf = new ArrayList< Conference >();
			conf.addAll(getConference());  
			mv.addObject("confer", conf); 
			return mv;
		}
		
		@RequestMapping(value="",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<Conference> getConference() {		
			List<Conference> lstConference = objConferenceRepo.listConferenceByDate();			
			return lstConference;			
		}
	
}
