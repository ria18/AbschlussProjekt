

package com.tqg.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tqg.model.Lizenz;
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Lizenz.class.isAssignableFrom(clazz);
	}
	
	  
	 

	@Override
	public void validate(Object target, Errors errors) {

		Lizenz user = (Lizenz) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lizenzName", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lizenzKey", "NotEmpty.userForm.name");


		if(user.getLizenzName()==null || user.getLizenzName() ==""){
			errors.rejectValue("lizenzName", "NotEmpty.lizenzForm.lizenzName");
		}
		if(user.getLizenzKey()==null || user.getLizenzKey() ==""){
			errors.rejectValue("lizenzKey", "NotEmpty.lizenzForm.lizenzKey");
		}
	}
	

}
