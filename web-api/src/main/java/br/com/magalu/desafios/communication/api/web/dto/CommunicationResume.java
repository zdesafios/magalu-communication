package br.com.magalu.desafios.communication.api.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunicationResume {
	private Long id;
	private String type;
	private String destination;
	private String content;
	private String when;
	private String status;
}
