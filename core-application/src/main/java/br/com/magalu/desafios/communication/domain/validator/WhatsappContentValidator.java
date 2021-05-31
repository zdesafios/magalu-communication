package br.com.magalu.desafios.communication.domain.validator;

public class WhatsappContentValidator implements ValidatorStrategy<String> {
	private static final int MAX_LENGTH = 4000;
	
	@Override
	public boolean isValid(String content) {
		if(null == content || content.isBlank() || content.length() > MAX_LENGTH) {
			return false;
		}
		
		return true; 
	}

}
