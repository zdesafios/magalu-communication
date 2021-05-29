package br.com.magalu.desafios.communication.domain.validator;

public class EmailContentValidator implements ValidatorStrategy<String> {

	@Override
	public boolean isValid(String content) {
		return !content.isBlank();
	}

}
