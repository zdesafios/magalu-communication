package br.com.magalu.desafios.communication.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;

@Embeddable
public class Content {
	
	@Column(name = "content")
	private String text;
	
	public Content(String text, CommunicationType type) {
		validateTextByType(text, type);
		this.text = text;
	}
	
	private void validateTextByType(String text, CommunicationType type) {
		if(type.getContentValidator().isValid(text)) {
			throw new IllegalArgumentException();
		}
	}
}
