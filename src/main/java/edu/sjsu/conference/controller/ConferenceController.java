package edu.sjsu.conference.controller;

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
import edu.sjsu.conference.domain.AwsService;
import edu.sjsu.conference.repository.ConferenceRepository;

@Controller
@RequestMapping("/NewConference")
public class ConferenceController {
	@Autowired
	private ConferenceRepository repository;

		private AwsService awsService;
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
		conference.setParticipantEmailList(Arrays.asList(participantArray));
		System.out.println("particpants email : "
				+ conference.getParticipantEmailList());

		//Insert into the collection conference, if collection not present then create it
		repository.addConference(conference);
		// Send emails to the participants using AWS SNS [START]
		SendInvitationWithSNS(participantArray);
		// Send emails to the participants using AWS SNS [END]
		// Display all the documents from the collection
		List<Conference> part = repository.listConference();
		for (int i = 0; i < part.size(); i++) {
			log.debug("All Conference details:" + part.get(i));
		}
		return "redirect:/UserHome";
	}
	    public void SendInvitationWithSNS(String[] emailList)
	    {
			String[] emailListToBeDelated;//delete this line for the demo
	    	//FIXME
			//TODO: Remove hardcoded email id lists. For testing purpose, give your email id.
			String emailIds = "ramya.machina@gmail.com,ramya.machina@yahoo.com,ramya.machina@sjsu.edu";//delete this line for the demo
			emailListToBeDelated = emailIds.split(",");//delete this line for the demo
			AWSSNS sns = awsService.create();

			if(sns != null)
				{
					sns.addSubscribers(emailListToBeDelated);// replace emailListToBeDelated with emailList for the demo.
				}
		}
}
