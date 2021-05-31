package br.com.magalu.desafios.communication.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Model;
import lombok.Getter;


@Embeddable
public class Destination extends Model {
	@Getter
	@Column
	private String recipient;
	
	public Destination() {}
	
	public Destination(String recipient, CommunicationType type) {
		validateDestinationByType(recipient, type);
		this.recipient = recipient;
	}

	private void validateDestinationByType(String recipient, CommunicationType type) {
		if(null == type || !type.getFormatValidator().isValid(recipient)) {
			addNotification("comunication.destination", "destination do not compatible  with type");
		}
	}

}
