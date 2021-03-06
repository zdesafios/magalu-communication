package br.com.magalu.desafios.communication.api.exception.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.magalu.desafios.communication.api.web.dto.response.NotificationsResponse;
import br.com.magalu.desafios.communication.app.exceptions.CommunicationAlreadyExistsException;
import br.com.magalu.desafios.communication.app.exceptions.CommunicationNotFoundException;
import br.com.magalu.desafios.communication.app.exceptions.InvalidCommunicationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(CommunicationAlreadyExistsException.class)
	public NotificationsResponse conflict(CommunicationAlreadyExistsException e) {
		log.error("Communication already exists", e);
		return new NotificationsResponse("communication", "Communication already exists");
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCommunicationException.class)
	public List<NotificationsResponse> badrequest(InvalidCommunicationException e) {
		log.error("Invalid communication", e);
		return e.getNotifies().stream()
				.map(n-> new NotificationsResponse(n.getPath(), n.getMessage()))
				.collect(Collectors.toList());
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CommunicationNotFoundException.class)
	public NotificationsResponse badrequest(CommunicationNotFoundException e) {
		log.error("Communication not found", e);
		return new NotificationsResponse("communication.id", "Communication Not Found with id " + e.getCommunication());
	}

}
