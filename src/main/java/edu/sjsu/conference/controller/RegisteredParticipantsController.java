package edu.sjsu.conference.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@RequestMapping("/RegisteredParticipant")
@Scope("request")
public class RegisteredParticipantsController {
	@Autowired
	private User user;

	@Autowired
	private ConferenceRepository repository;
	
	protected static Logger log = Logger.getLogger("RegisteredParticipantsController");

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ModelAndView registerParticipant(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("RegisteredParticipant");
		HashMap<String, String> obj = repository.getAttendees(id);
		mv.addObject("participants",obj);
		return mv;
	}

}
