package br.com.magalu.desafios.communication.api.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunicationResume {
	private String type;
	private String destination;
	private String content;
	private String when;
}
