package br.com.magalu.desafios.communication.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import br.com.magalu.desafios.communication.domain.element.CommunicationStatus;
import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.vo.Content;
import br.com.magalu.desafios.communication.domain.vo.Destination;
import lombok.Getter;

@Getter
@Entity
@Table(name = "communications")
public class Communication extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "when_date", nullable = false)
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
	private LocalDateTime updatedAt;
	
	
	public Communication() {}
	
	public Communication(CommunicationType type) {
		this.status = CommunicationStatus.PENDING;
		this.type = type;
		if(null == type) {
			addNotification("communication.type", "'type' is empty");
		}
	}
	
	public void setWhen(LocalDateTime when) {
		
		if(null == when) {
			addNotification("communication.when", "'when' needs to be in the future");
			return;
		}
		
		if(checkIfCanNotUpdate()) {
			addNotification("communication.when", "'when' not updated, because the communication has already been sent");
			return;
		}
		
		when = when.withSecond(0);
		
		var now = LocalDateTime.now().withSecond(0);
		boolean dateIsNotFuture = when.isEqual(now) || when.isBefore(now);
		if(dateIsNotFuture) {
			addNotification("communication.when", "'when' needs to be in the future");
			return;
		}
		
		this.when = when;
	}
	
	public void setDestination(String destinationAsString) {
		if(checkIfCanNotUpdate()) {
			addNotification("communication.destination", "'destination' not updated, because the communication has already been sent");
			return;
		}
		destination = new Destination(destinationAsString, type);
		addNotifications(destination.notifications());
	}
	
	public void setContent(String contentAsString) {		
		if(checkIfCanNotUpdate()) {
			addNotification("communication.content", "'content' not updated, because the communication has already been sent");
			return;
		}
		
		content = new Content(contentAsString, type);
		addNotifications(content.notifications());
	}
	
	public void markAsCanceled() {
		if(checkIfCanNotUpdate()) {
			addNotification("communication.status", "'status' not updated, because the communication has already been sent");
			return;
		}
		
		this.status = CommunicationStatus.CANCELED;
	}

	public void markAsSent() {
		if(null == id) {
			addNotification("communication.status", "'status' not updated, because the communication has already been sent");
			return;
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
	
	@PrePersist
	private void prePersist() {
		createdAt = LocalDateTime.now();
	}
	
	private void preUpdate() {
		updatedAt = LocalDateTime.now();
	}

	

	
}
