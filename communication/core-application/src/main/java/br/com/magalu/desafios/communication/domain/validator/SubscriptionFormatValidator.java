package br.com.magalu.desafios.communication.domain.validator;

import org.apache.commons.validator.routines.RegexValidator;

public class SubscriptionFormatValidator implements ValidatorStrategy<String> {
	private static final RegexValidator UUID_REGEX = new RegexValidator("^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$");

	@Override
	public boolean isValid(String subscription) {
		return UUID_REGEX.isValid(subscription);
	}

}
