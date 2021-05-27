package br.com.magalu.desafios.communication.core.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.magalu.desafios.communication.core.domain.enums.CommunicationStatus;
import br.com.magalu.desafios.communication.core.domain.enums.DestinationType;
import br.com.magalu.desafios.communication.core.domain.vo.Content;
import br.com.magalu.desafios.communication.core.domain.vo.Destination;

@Entity
@Table(name = "communications")
public class Communication {
	@Id
	private String id;
	
	@Column(nullable = false)
	private LocalDateTime when;
	
	@Column
	private LocalDateTime sentAt;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DestinationType sendType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CommunicationStatus status;
	
	@Embedded
	private Destination destination;
	
	@Embedded
	private Content content;
	
	private LocalDateTime createdAt;
	
	public Communication() {
		this.status = CommunicationStatus.PENDING;
	}
	
	public void setWhen(LocalDateTime when) {
		if(canNotUpdate()) {
			// não pode atualizar status
		}
		boolean isBefore = when.isBefore(LocalDateTime.now());
		if(isBefore) {
			// levantar exceção para argumento inválido
		}
		
		this.when = when;
	}
	
	public void setDestinationAndType(String destinationAsString, DestinationType destinationType) {
		if(canNotUpdate()) {
			// não pode atualizar status
		}
		
		this.destination = new Destination(destinationAsString, destinationType);
	}
	
	public void setContent(String contentAsString) {
		if(canNotUpdate()) {
			// não pode atualizar status
		}
		
		this.content = new Content(contentAsString);
	}
	
	public boolean isSent() {
		return CommunicationStatus.SENT == status;
	}
	
	public boolean isPending() {
		return CommunicationStatus.PENDING == status;
	}
	
	private boolean canNotUpdate() {
		return isSent();
	}
	
}
