package br.com.magalu.desafios.communication.app.exceptions;

import java.util.List;

import br.com.magalu.desafios.communication.domain.entity.Notification;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IvalidCommunicationException extends RuntimeException {

	List<Notification> notifies;
	
}
