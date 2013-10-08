package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.conference.domain.Participant;
import edu.sjsu.conference.domain.Speaker;


@Controller
@RequestMapping("/SpeakerPage")

public class speakerController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupRegistration(@ModelAttribute("speaker") Speaker speaker1 , BindingResult speaker) {
        //model.addAttribute("user", new User());
        return "SpeakerPage"; 
    }

	@RequestMapping(method = RequestMethod.POST)
    public String registerParticipant( @ModelAttribute("speaker") @Valid Speaker speaker1, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "registerParticipant";
        }
        model.addAttribute("SpeakerFirstName", speaker1.getFirstName());
        model.addAttribute("SpeakerLastName", speaker1.getLastName());
        model.addAttribute("SpeakerLocation", speaker1.getLocation());
        model.addAttribute("SpeakerRole", speaker1.getRole());
		return "success";
        
    }

}
