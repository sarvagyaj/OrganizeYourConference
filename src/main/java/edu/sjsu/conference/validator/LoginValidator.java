package edu.sjsu.conference.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.sjsu.conference.domain.LoginPage;

public class LoginValidator implements Validator{
	
	@Override
	public boolean supports(Class clazz) {
		//just validate the login instances
		return LoginPage.class.isAssignableFrom(clazz);

	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
				"required.emailId", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
			
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.confirmPassword", "Field name is required.");
		
		//LoginPage loginpage = (LoginPage)target;
		
		if(!(loginpage.getPassword().equals(loginpage.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password");
		}*/
			
	}
	

}
