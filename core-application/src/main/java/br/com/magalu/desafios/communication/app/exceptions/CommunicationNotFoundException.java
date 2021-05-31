package br.com.magalu.desafios.communication.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunicationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private Long communication;
}
