package br.com.magalu.desafios.communication.api.web.dto.request;

import lombok.Getter;

@Getter
public class CreateCommunicationRequest {
	private String type;
	
	private String content;
	
	private String destination;
	
	private String when;
}
