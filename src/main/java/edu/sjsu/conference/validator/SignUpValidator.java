package edu.sjsu.conference.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;


import org.springframework.validation.Validator;

import edu.sjsu.conference.domain.User;

public class SignUpValidator implements Validator{
	@Override
	public boolean supports(Class clazz) {
		//just validate the login instances
		return User.class.isAssignableFrom(clazz);

	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"required.firstName", "First name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"required.lastName", "Last name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
				"required.emailId", "User name is required.");		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Password is required.");
		
			
		User objUser = (User)target;
		
		if(!(objUser.getPassword().equals(objUser.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password");
		}
		if(!(objUser.getEmailId() != null) && !(("").equals(objUser.getEmailId())) && !(objUser.getEmailId().contains("@"))){
			errors.rejectValue("emailId", "notmatch.emailId");
		}
			
	}
}
