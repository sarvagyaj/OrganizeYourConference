package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;


@Controller
@Scope("request")
@RequestMapping("/RSVPForm")
public class RSVPcontroller {
	
	@Autowired
	private User user;
	
	private int ConferenceId;
	
	@Autowired
	private ConferenceRepository repository;
	
	protected static Logger log = Logger.getLogger("RSVPcontroller");
		
	@RequestMapping(value="/{conferenceId}",method = RequestMethod.GET)
	public ModelAndView initForm(@PathVariable("conferenceId") int id){
		User newUser = new User();
		System.out.println("Inside RSVP COntroller got id-->" + id);
		ModelAndView model = new ModelAndView("RSVPForm");
		this.ConferenceId = id;
		model.addObject("conferenceId", id);
		model.addObject("user", newUser);
 		return model;
	}
	
	@RequestMapping(value="/{conferenceId}", method = RequestMethod.POST)
	public ModelAndView acceptedInvitation(@PathVariable("conferenceId") int id, @ModelAttribute("user") @Valid User newUser,
			ModelMap model, BindingResult result) {		
		log.debug("acceptedInvitation : RSVPcontroller ");
		System.out.println("-------->>>> Yes RSVP COntroller with =" + id);
		ModelAndView mv = new ModelAndView("RSVPForm");
		repository.addAttendees(id,newUser.getEmailId());
		mv.addObject("msg", "Thanks You!! Your Response Has been Recorded !! Successfully Registered !");
 		return mv;			
	}

}
