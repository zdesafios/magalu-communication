package br.com.magalu.desafios.communication.domain.validator;

public class SubscriptionContentValidator implements ValidatorStrategy<String> {
	private static final int CONTENT_MAX_LENGTH = 200;
	
	@Override
	public boolean isValid(String content) {
		if(null == content || content.isBlank() || content.length() > CONTENT_MAX_LENGTH) {
			return false;
		}
			
		return true;
	}

}
