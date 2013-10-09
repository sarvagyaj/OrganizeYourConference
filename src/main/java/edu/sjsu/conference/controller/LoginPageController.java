package edu.sjsu.conference.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HttpServletBean;

import edu.sjsu.conference.domain.LoginPage;
 

@Controller
@RequestMapping("/LoginPage")
//@SessionAttributes("participant")


public class LoginPageController {
		@RequestMapping(method = RequestMethod.GET)
	    public String setupRegistration(@ModelAttribute("loginpage") LoginPage loginpage1 , BindingResult loginpage) {
	        return "LoginPage"; 
	    }

		//yet to be implemented fully
	    @RequestMapping(method = RequestMethod.POST)
	    public String LoginPage(BindingResult result, ModelMap model) {
	        
			return "success";
	        
	    }
}

