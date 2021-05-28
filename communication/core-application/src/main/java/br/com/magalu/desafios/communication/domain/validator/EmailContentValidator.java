package br.com.magalu.desafios.communication.domain.validator;

public class EmailContentValidator implements ValidatorStrategy<String> {

	@Override
	public boolean isValid(String content) {
		if(content.isBlank()) {
			return false;
		}
		return true;
	}

}
