package br.com.magalu.desafios.communication.core.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.magalu.desafios.communication.core.domain.enums.DestinationType;

@Embeddable
public class Destination {
	@Column
	private String destination;
	
	@Column
	private DestinationType destinationType;
	
	public Destination(String destinationAsString, DestinationType destinationType) {
		this.destination = destinationAsString;
		this.destinationType = destinationType;
	}

}
