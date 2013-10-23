package edu.sjsu.conference.controller;

import javax.validation.Valid;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import edu.sjsu.conference.config.MongoConfig;
import edu.sjsu.conference.domain.Participant;
import edu.sjsu.conference.domain.Speaker;
import edu.sjsu.conference.repository.SpeakerRepository;


@Controller
@RequestMapping("/SpeakerPage")

public class SpeakerController {

	//Code related to MongoDB [START]
    @Autowired
    private SpeakerRepository speakerRepository;

    protected static Logger log = Logger.getLogger("RegisterParticipantController");
	//Code related to MongoDB [END]
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupRegistration(@ModelAttribute("speaker") Speaker speaker1 , BindingResult speaker) {
        //model.addAttribute("user", new User());
        return "SpeakerPage"; 
    }

	@RequestMapping(method = RequestMethod.POST)
    public String registerSpeaker( @ModelAttribute("speaker") @Valid Speaker speaker1, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "registerSpeaker";
        }

        //Code related to MongoDB [START]
        log.debug("registerSpeaker() : speaker = "+speaker1.toString());

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        SpeakerRepository repository = context.getBean(SpeakerRepository.class);
        
        //Create collection and insert into it.
        repository.addSpeaker(speaker1);

        //Code related to MongoDB [END]

        model.addAttribute("SpeakerFirstName", speaker1.getFirstName());
        model.addAttribute("SpeakerLastName", speaker1.getLastName());
        model.addAttribute("SpeakerLocation", speaker1.getLocation());
        model.addAttribute("SpeakerRole", speaker1.getRole());
		return "success";
        
    }

}
