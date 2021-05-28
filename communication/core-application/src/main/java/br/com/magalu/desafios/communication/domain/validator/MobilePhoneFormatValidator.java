package br.com.magalu.desafios.communication.domain.validator;

import org.apache.commons.validator.routines.RegexValidator;

public class MobilePhoneFormatValidator implements ValidatorStrategy<String> {
	
	@Override
	public boolean isValid(String mobilePhone) {
		RegexValidator a = new RegexValidator("");
		
		var codeAsString = "";
		if(codeAsString.isBlank()) {
			return false;
		}
		
		var countyCode = FormatCountryCode.fromCodeOrNull(codeAsString);
		if(null == countyCode) {
			return false;
		}
		
		return new RegexValidator(countyCode.regex).isValid(mobilePhone);
	}



}
