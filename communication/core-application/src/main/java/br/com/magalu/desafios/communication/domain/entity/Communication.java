package br.com.magalu.desafios.communication.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.magalu.desafios.communication.domain.element.CommunicationStatus;
import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.vo.Content;
import br.com.magalu.desafios.communication.domain.vo.Destination;

@Entity
@Table(name = "communications")
public class Communication extends Model {
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
		if(checkIfCanNotUpdate()) {
			addNotification("communication.when", "'when' not updated, because the communication has already been sent");
		}
		
		boolean dateIsNotFuture = when.isEqual(LocalDateTime.now()) || when.isBefore(LocalDateTime.now());
		if(dateIsNotFuture) {
			addNotification("communication.when", "'when' needs to be in the future");
		}
		
		this.when = when;
	}
	
	public void setDestinationAndType(String destinationAsString, CommunicationType communicationType) {
		if(checkIfCanNotUpdate()) {
			addNotification("communication.destination", "'destination' not updated, because the communication has already been sent");
		}
		destination = new Destination(destinationAsString, communicationType);
		addNotifications(destination.notifications());
	}
	
	public void setContentAndType(String contentAsString, CommunicationType communicationType) {
		if(checkIfCanNotUpdate()) {
			addNotification("communication.content", "'content' not updated, because the communication has already been sent");
		}
		content = new Content(contentAsString, communicationType);
		addNotifications(content.notifications());
	}
	

	public void markAsSent() {
		if(null == id) {
			addNotification("communication.status", "'status' not updated, because the communication has already been sent");
		}
		status = CommunicationStatus.SENT;
	}
	
	public boolean isSent() {
		return CommunicationStatus.SENT == status;
	}
	
	public boolean isPending() {
		return CommunicationStatus.PENDING == status;
	}
	
	private boolean checkIfCanNotUpdate() {
		return isSent();
	}

	
}
