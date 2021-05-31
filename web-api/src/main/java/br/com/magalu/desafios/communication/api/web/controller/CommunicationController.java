package br.com.magalu.desafios.communication.api.web.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magalu.desafios.communication.api.facade.CommunicationFacade;
import br.com.magalu.desafios.communication.api.web.dto.CommunicationResume;
import br.com.magalu.desafios.communication.api.web.dto.request.CreateCommunicationRequest;
import br.com.magalu.desafios.communication.api.web.dto.request.GetCommunicationsRequestQuery;

@RestController
@RequestMapping("/communications")
public class CommunicationController {
	
	@Autowired
	private CommunicationFacade communicationFacade;

	@PostMapping
	public ResponseEntity<?> creaate(@Valid @RequestBody CreateCommunicationRequest request) {
		var response = communicationFacade.create(request);
		var location = URI.create(String.format("/communications/%s", response.getId()));
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{communication}")
	public ResponseEntity<?> update() {
		return null;
	}
	
	@GetMapping
	public ResponseEntity<List<CommunicationResume>> list(@Valid GetCommunicationsRequestQuery request) {
		return ResponseEntity.ok(communicationFacade.list(request));
	}
	
	@PatchMapping("/{communication}/status")
	public ResponseEntity<?> details(@PathVariable("communication") Long communication) {
		return ResponseEntity.ok(communicationFacade.attemptCancelCommunication(communication));
	}
	
}
