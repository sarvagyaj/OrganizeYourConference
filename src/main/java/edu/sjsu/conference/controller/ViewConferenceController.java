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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@RequestMapping("/ViewConference")
@Scope("request")
public class ViewConferenceController {
		
	@Autowired
	ConferenceRepository objConferenceRepo;
	
	@Autowired
	User user;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String setupHome() {
		return "ViewConference";
	}

	//Home of user, the page which he will he when he logs in
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ModelAndView returnIdPage(@PathVariable("id") String id) {
		System.out.println("id  is : "+  id);
		//String userRole = "Organizer";
		ModelAndView mv = new ModelAndView("ViewConference");
		Conference objConf; 
		objConf = objConferenceRepo.fetchConferenceById(id);
		mv.addObject("confer", objConf); 
		mv.addObject("user", user); 
		return mv;
	}
}
