package br.com.magalu.desafios.communication.domain.validator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FormatCountryCode {
	BR("^(\\d{11})$"),
	US("^(\\\\d{10})$");
	
	String regex;

	static FormatCountryCode fromCodeOrNull(String codeAsString) {
		return null;
	}
}
