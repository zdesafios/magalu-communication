package br.com.magalu.desafios.communication.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Model;


@Embeddable
public class Destination extends Model {
	@Column
	private String recipient;
	
	public Destination(String recipient, CommunicationType type) {
		validateDestinationByType(recipient, type);
		this.recipient = recipient;
	}

	private void validateDestinationByType(String recipient, CommunicationType type) {
		if(!type.getFormatValidator().isValid(recipient)) {
			addNotification("comunication.destination", "destination do not compatible  with " + type.name());
		}
	}

}
