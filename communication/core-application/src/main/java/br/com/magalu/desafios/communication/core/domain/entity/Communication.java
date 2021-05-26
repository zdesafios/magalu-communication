package br.com.magalu.desafios.communication.core.domain.entity;

import java.time.LocalDateTime;

import br.com.magalu.desafios.communication.core.domain.enums.CommunicationStatus;
import br.com.magalu.desafios.communication.core.domain.enums.SendType;

public class Communication {
	private String id;
	private LocalDateTime datetime;
	private String to;
	private String content;
	private LocalDateTime sentDatetime;
	
	private SendType sendType;
	
	private CommunicationStatus status;
	
	private LocalDateTime createdAt;
}
