package edu.sjsu.conference.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@RequestMapping("/NewConference")
public class ConferenceController {
	@Autowired
	private ConferenceRepository repository;

	protected static Logger log = Logger.getLogger("ConferenceController");

	@RequestMapping(method = RequestMethod.GET)
	public String setupRegistration(
			@ModelAttribute("conference") Conference conference,
			BindingResult result) {
		return "NewConference";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String Conference(
			@ModelAttribute("conference") @Valid Conference conference,
			BindingResult result, ModelMap model) {
		log.debug("registerConference() : conference = "
				+ conference.toString());

		//Set participants emails' from the text in html
		String[] participantArray = conference.getParticipants().split(",");
		conference.setInvitedParticipantsList(Arrays.asList(participantArray));
		List<String> attendees = new ArrayList<String>();
		conference.setAttendees(attendees);
		System.out.println("attendees are: " + conference.getAttendees());

		//Insert into the collection conference, if collection not present then create it
		repository.addConference(conference);
		// Display all the documents from the collection
		//	List<Conference> part = repository.listConference();
		/*for (int i = 0; i < part.size(); i++) {
			log.debug("All Conference details:" + part.get(i));
		}*/
		return "redirect:/UserHome";
	}
}
