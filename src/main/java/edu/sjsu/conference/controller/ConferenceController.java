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
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.ConferenceRepository;
import edu.sjsu.conference.domain.AwsService;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
@Controller
@RequestMapping("/NewConference")
public class ConferenceController {
	@Autowired
	private ConferenceRepository repository;
	private User user;
	private JobDetail job;

	private AwsService awsService;
	
	protected static Logger log = Logger.getLogger("ConferenceController");

	@RequestMapping(method = RequestMethod.GET)
	public String setupRegistration(
			@ModelAttribute("conference") Conference conference,
			BindingResult result) {
		return "NewConference";
	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getConference() {
		ModelAndView mv = new ModelAndView("NewConference");
		mv.addObject("user", user);
		return mv;
	}*/
	

	@RequestMapping(method = RequestMethod.POST)
	public String Conference(
			@ModelAttribute("conference") @Valid Conference conference,
			BindingResult result, ModelMap model) {
		log.debug("registerConference() : conference = "+ conference.toString());

		//Set participants emails' from the text in html
		String[] participantArray = conference.getParticipants().split(",");
		conference.setInvitedParticipantsList(Arrays.asList(participantArray));
		System.out.println("particpants email : "+ conference.getInvitedParticipantsList());

		//Insert into the collection conference, if collection not present then create it
		repository.addConference(conference);
		// Send emails to the participants using AWS SNS [START]
		SendInvitationWithSNS(participantArray, conference.getId());
		// Send emails to the participants using AWS SNS [END]
		// Display all the documents from the collection
		List<Conference> part = repository.listConference();
		for (int i = 0; i < part.size(); i++) {
			log.debug("All Conference details:" + part.get(i));
		}
		return "redirect:/UserHome";
	}
	    public void SendInvitationWithSNS(String[] emailList, int aId)
	    {
			String[] emailListToBeDelated;//delete this line for the demo
	    	//FIXME
			//TODO: Remove hardcoded email id lists. For testing purpose, give your email id.
			String emailIds = "ramya.machina@gmail.com,machina_ramya@yahoo.com,ramya.machina@sjsu.edu";//delete this line for the demo
			emailListToBeDelated = emailIds.split(",");//delete this line for the demo
			AWSSNS sns = awsService.create();
			
			//Schedular for every 60 secs [START]
				
            try{

            	System.out.println("Job = "+job);

            	if(job==null){

			        job = new JobDetail();
			    	job.setName("publishJob");
			    	job.setJobClass(AWSSNS.class);
			 
			    	CronTrigger trigger = new CronTrigger();
			    	trigger.setName("TriggerName");
			    	trigger.setCronExpression("0/60 * * * * ?");
			 
			    	//schedule it
			    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			    	scheduler.start();
			    	scheduler.scheduleJob(job, trigger);
			    }
			    else
			    	System.out.println("Schedular is running...");

		    	} catch (Exception e) {                      
		                    e.printStackTrace();
		                } 
			//Quartz END

			if(sns != null)
				{
					sns.addSubscribers(emailListToBeDelated, aId);// replace emailListToBeDelated with emailList for the demo.
				}
		}
}
