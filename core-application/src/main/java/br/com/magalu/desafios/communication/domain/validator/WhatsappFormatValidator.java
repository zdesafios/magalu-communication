package br.com.magalu.desafios.communication.domain.validator;

import org.apache.commons.validator.routines.RegexValidator;


public class WhatsappFormatValidator implements ValidatorStrategy<String> {
	private static final RegexValidator WHATSAPP_ID_REGEX = new RegexValidator("^\\+\\d+$");
	
	@Override
	public boolean isValid(String mobilePhone) {
		return WHATSAPP_ID_REGEX.isValid(mobilePhone);
	}

}
