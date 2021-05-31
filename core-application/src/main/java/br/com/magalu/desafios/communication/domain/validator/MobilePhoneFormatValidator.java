package br.com.magalu.desafios.communication.domain.validator;

import org.apache.commons.validator.routines.RegexValidator;


public class MobilePhoneFormatValidator implements ValidatorStrategy<String> {
	private static final RegexValidator MOBILE_PHONE_REGEX = new RegexValidator("^\\+\\d+$");
	
	@Override
	public boolean isValid(String mobilePhone) {
		return MOBILE_PHONE_REGEX.isValid(mobilePhone);
	}

}
