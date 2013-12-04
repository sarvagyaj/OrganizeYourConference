package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@Scope("request")
@RequestMapping("/UpdateConference")
public class UpdateConferenceController {
	@Autowired
	private User user;
	@Autowired
	private ConferenceRepository repository;
	
	protected static Logger log = Logger.getLogger("OrganizeYourConference");

	//View Profile
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView getProfile(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("EditConference");
		Conference conference = repository.fetchConferenceById(id);
		log.debug("conf id is :"+id +" and topic is "+conference.getTopic());
		mv.addObject("conference", conference);
		return mv;
	}
	
	//Edit Conference
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public ModelAndView updateConference(@PathVariable("id") int id, @ModelAttribute("conference") @Valid Conference conference,
			BindingResult result) {
		conference.setId(id);
		log.debug("conf id which is to be updated :" + id);
		Conference updatedConf=repository.updateConference(conference);
		
		ModelAndView mv = new ModelAndView("EditConference");
		mv.addObject("conference", updatedConf);
		return mv;
	}
}
