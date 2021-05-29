package br.com.magalu.desafios.communication.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Model;


@Embeddable
public class Destination extends Model {
	@Column
	private String destination;
	
	public Destination(String destinationAsString, CommunicationType type) {
		validateDestinationByType(destinationAsString, type);
		this.destination = destinationAsString;
	}

	private void validateDestinationByType(String destinationAsString, CommunicationType type) {
		if(!type.getFormatValidator().isValid(destinationAsString)) {
			addNotification("comunication.destination", "destination do not compatible  with " + type.name());
		}
	}

}
