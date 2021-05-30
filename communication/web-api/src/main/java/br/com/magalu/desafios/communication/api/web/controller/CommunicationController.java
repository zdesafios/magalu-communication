package br.com.magalu.desafios.communication.api.web.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magalu.desafios.communication.api.CommunicationFacade;
import br.com.magalu.desafios.communication.api.web.dto.request.CreateCommunicationRequest;
import br.com.magalu.desafios.communication.api.web.dto.response.CreateCommunicationResponse;

@RestController
@RequestMapping("/communications")
public class CommunicationController {
	
	@Autowired
	private CommunicationFacade communicationFacade;

	@PostMapping
	public ResponseEntity creaate(@Valid @RequestBody CreateCommunicationRequest request) {
		
		CreateCommunicationResponse response = communicationFacade.create(request);
		
		var location = URI.create(String.format("/communications/%s", "id"));
		return ResponseEntity.created(location).build();
	}
	
}
