package edu.sjsu.conference.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.User;
import edu.sjsu.oauth.LinkedInHelper;

@Controller
@RequestMapping("/linkedin")
public class LinkedInController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView setup(HttpServletRequest request) {

		String code = request.getParameter("code");
		if (code == null || code == "") {
			return new ModelAndView("error");
		}
		User user = LinkedInHelper.getUserDetails(code);

		if (user == null) {
			return new ModelAndView("error");
		}
		ModelAndView mv = new ModelAndView("SignUp");
		mv.addObject("user", user);
		return mv;
	}
}
