package br.com.magalu.desafios.communication.domain.validator;

public class EmailContentValidator implements ValidatorStrategy<String> {
	public static final int MAX_LENGTH = 200;
	

	@Override
	public boolean isValid(String content) {
		return null != content && !content.isBlank() && content.length() < MAX_LENGTH;
	}

}
