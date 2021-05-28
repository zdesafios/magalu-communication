package br.com.magalu.desafios.communication.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;


@Embeddable
public class Destination {
	@Column
	private String destination;
	
	public Destination(String destinationAsString, CommunicationType type) {
		validateDestinationByType(destinationAsString, type);
		this.destination = destinationAsString;
	}

	private void validateDestinationByType(String destinationAsString, CommunicationType type) {
		if(!type.getFormatValidator().isValid(destinationAsString)) {
			throw new IllegalArgumentException();
		}
	}

}
