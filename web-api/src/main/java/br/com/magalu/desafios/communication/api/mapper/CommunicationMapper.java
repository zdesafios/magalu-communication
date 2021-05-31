package br.com.magalu.desafios.communication.api.mapper;

import org.springframework.stereotype.Component;

import br.com.magalu.desafios.communication.api.web.dto.request.CreateCommunicationRequest;
import br.com.magalu.desafios.communication.api.web.dto.response.CreateCommunicationResponse;
import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Communication;

@Component
public class CommunicationMapper {

	public Communication requestToEntity(CreateCommunicationRequest request) {
		var communication = new Communication(CommunicationType.valueOf(request.getType()));
		communication.setContent(request.getContent());
		communication.setDestination(request.getDestination());
		communication.setWhen(request.getWhen());
		
		return communication;
	}

	public CreateCommunicationResponse entityToResponse(Communication communication) {
		return new CreateCommunicationResponse(communication.getId());
	}

}
