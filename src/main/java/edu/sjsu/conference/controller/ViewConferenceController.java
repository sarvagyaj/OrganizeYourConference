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
import edu.sjsu.conference.uploadfiles.DropboxTest;

@Controller
@RequestMapping("/ViewConference")
@Scope("request")
public class ViewConferenceController {
		
	@Autowired
	ConferenceRepository objConferenceRepo;
	
	@Autowired
	User user;
	
	@Autowired
	Conference sessionConference;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String setupHome() {
		return "ViewConference";
	}

	//Home of user, the page which he will he when he logs in
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ModelAndView returnIdPage(@PathVariable("id") String id) {
		System.out.println("id  is : "+  id);
		String msg = "";
		ModelAndView mv = new ModelAndView("ViewConference");
		if(id.contains("_")){
			System.out.println("id  is : "+  id);
			msg = id.split("_")[1];
			mv.addObject("msg", msg);
			id = id.split("_")[0];
		}
		System.out.println("id after is : "+  id);
		//String userRole = "Organizer";
		Integer objId = Integer.parseInt(id);
		
		Conference objConf; 
		sessionConference.setId(objId);
		//String dropboxURL = DropboxTest.sharedURL;
		objConf = objConferenceRepo.fetchConferenceById(objId);
		mv.addObject("confer", objConf); 
		mv.addObject("user", user); 
		mv.addObject("dropboxURL", objConf.getDropbox_link());
		return mv;
	}
}
