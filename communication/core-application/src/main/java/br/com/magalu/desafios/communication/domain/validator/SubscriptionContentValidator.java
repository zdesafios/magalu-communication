package br.com.magalu.desafios.communication.domain.validator;

public class SubscriptionContentValidator implements ValidatorStrategy<String> {
	private static final int CONTENT_MAX_LENGTH = 200;
	
	@Override
	public boolean isValid(String content) {
		if(content.isBlank()) {
			return false;
		}
		
		if(content.length() > CONTENT_MAX_LENGTH) {
			return false;
		}
		
		return true;
	}

}
