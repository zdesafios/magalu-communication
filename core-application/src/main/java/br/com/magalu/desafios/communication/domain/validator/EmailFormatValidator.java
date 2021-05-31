package br.com.magalu.desafios.communication.domain.validator;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailFormatValidator implements ValidatorStrategy<String> {
	
	@Override
	public boolean isValid(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

}
