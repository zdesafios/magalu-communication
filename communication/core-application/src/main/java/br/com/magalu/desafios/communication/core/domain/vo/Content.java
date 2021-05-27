package br.com.magalu.desafios.communication.core.domain.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Content {
	private String text;
	
	public Content(String text) {
		this.text = text;
	}
}
