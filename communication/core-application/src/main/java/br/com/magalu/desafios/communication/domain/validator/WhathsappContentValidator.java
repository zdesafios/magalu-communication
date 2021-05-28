package br.com.magalu.desafios.communication.domain.validator;

public class WhathsappContentValidator implements ValidatorStrategy<String> {
	private static final int MAX_LENGTH = 160;
	
	@Override
	public boolean isValid(String phone) {
		if(phone.isBlank()) {
			return false;
		}
		
		if(phone.length() > MAX_LENGTH) {
			return false;
		}
		
		return true; 
	}

}
