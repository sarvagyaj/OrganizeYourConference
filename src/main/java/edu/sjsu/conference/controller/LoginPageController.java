package edu.sjsu.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.repository.UserRepository;
import edu.sjsu.conference.validator.LoginValidator;

@Controller
@Scope("request")
@RequestMapping("/LoginPage")
public class LoginPageController {

	LoginValidator loginValidator;

	@Autowired
	private UserRepository repository;

	@Autowired
	private User user;

	@Autowired
	public LoginPageController(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {

		// LoginPage loginpage = new LoginPage();
		User newUser = new User();
		model.addAttribute("loginpage", newUser);
		return "LoginPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("loginpage") User loggedUser,
			BindingResult result, SessionStatus status) {

		loginValidator.validate(loggedUser, result);

		if (result.hasErrors()) {
			// if validator failed
			return "LoginPage";
		} else {
			System.out.println("username is : " + loggedUser.getEmailId() + " "
					+ loggedUser.getPassword() + " " + loggedUser.getRole());
			User newUser = repository.getUser(loggedUser.getEmailId(),
					loggedUser.getRole());

			//loginValidator.validate(target, errors);
			if (newUser != null
					&& loggedUser.getPassword().equals(newUser.getPassword())
					&& loggedUser.getRole().equalsIgnoreCase(newUser.getRole())) {
				System.out.println("correct password");

				// setting session object "user"
				user.setUser(newUser);
				status.setComplete();
				// form success
				return "UserHome";
			} else {
				System.out.println("Incorrect username/password");
				return "LoginPage";
			}

		}
	}

}
