package br.com.magalu.desafios.communication.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.magalu.desafios.communication.app.exceptions.CommunicationAlreadySentException;
import br.com.magalu.desafios.communication.domain.element.CommunicationStatus;
import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.vo.Content;
import br.com.magalu.desafios.communication.domain.vo.Destination;

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
	private CommunicationType type;
	
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
		checkIfCanUpdate();
		this.when = when;
	}
	
	public void setDestinationAndType(String destinationAsString, CommunicationType communicationType) {
		checkIfCanUpdate();
		this.destination = new Destination(destinationAsString, communicationType);
	}
	
	public void setContentAndType(String contentAsString, CommunicationType communicationType) {
		checkIfCanUpdate();
		this.content = new Content(contentAsString, communicationType);
	}
	
	public void markAsSent() {
		if(null == id) {
			throw new IllegalArgumentException();
		}
		status = CommunicationStatus.SENT;
	}
	
	public boolean isSent() {
		return CommunicationStatus.SENT == status;
	}
	
	public boolean isPending() {
		return CommunicationStatus.PENDING == status;
	}
	
	private void checkIfCanUpdate() {
		if(isSent()) {
			throw new CommunicationAlreadySentException();
		}
	}
	
}
