package edu.sjsu.conference.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Logout")
public class LogoutController {

	protected static Logger log = Logger.getLogger("OrganizeYourConference");
	
	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpSession session) {
		log.debug("Logout Controller : Will logout now");
		session.invalidate();
		return "redirect:/LoginPage";
	}

}
