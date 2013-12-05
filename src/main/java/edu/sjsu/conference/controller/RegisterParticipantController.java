package edu.sjsu.conference.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@RequestMapping("/RegisterConference")
@Scope("request")
public class RegisterParticipantController {
		@Autowired
		private User user;
	
		@Autowired
    	private ConferenceRepository repository;
		
		protected static Logger log = Logger.getLogger("OrganizeYourConference");

		//add the participant if he is not registered for the conference
		@RequestMapping(value="/{id}",method = RequestMethod.GET)
	    public String registerParticipant(@PathVariable("id") int id) {			
			String msg ="";
			ModelAndView mv = new ModelAndView("redirect:/ViewConference/"+id);
			if(repository.checkParticipant(id, user.getEmailId())) {
				msg = "You have already been registered.";
				System.out.println("You have already been registered.");
				mv.addObject("msg", msg);
			}
			Conference conference= repository.addAttendees(id,user.getEmailId());
			if(conference != null) {
				msg = "user "+user.getEmailId()+" has been successfully registered for the conference " +id;
				System.out.println("user "+user.getEmailId()+" has been successfully registered for the conference " +id);
				//mv.addObject("msg", msg);
				mv.addObject("msg", msg);
				//return "redirect:/ViewConference/"+id;				
			} else { 
				msg = "Due to some techincal issues, you cannot be registered into the system at the moment.";
				System.out.println("Due to some techincal issues, you cannot be registered into the system at the moment.");
				mv.addObject("msg", msg);
				//return "redirect:/ViewConference/"+id;					
			}
			return "redirect:/ViewConference/"+id;
		}

}
