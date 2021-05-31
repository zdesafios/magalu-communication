package br.com.magalu.desafios.communication.app.exceptions;

import java.util.List;

import br.com.magalu.desafios.communication.domain.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidCommunicationException extends RuntimeException {

	private final List<Notification> notifies;
	
}
