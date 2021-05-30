package br.com.magalu.desafios.communication.domain.validator;

public class SMSContentValidator implements ValidatorStrategy<String> {
	private static final int MAX_LENGTH = 160;
	
	@Override
	public boolean isValid(String phone) {
		
		if(null == phone || phone.isBlank() || phone.length() > MAX_LENGTH) {
			return false;
		}
		
		return true; 
	}

}
