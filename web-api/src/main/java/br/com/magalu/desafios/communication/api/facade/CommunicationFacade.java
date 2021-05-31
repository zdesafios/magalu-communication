package br.com.magalu.desafios.communication.api.facade;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.magalu.desafios.communication.api.mapper.CommunicationMapper;
import br.com.magalu.desafios.communication.api.web.dto.request.CreateCommunicationRequest;
import br.com.magalu.desafios.communication.api.web.dto.response.CreateCommunicationResponse;
import br.com.magalu.desafios.communication.app.usecase.CreateCommunicationUsecase;

@Component
public class CommunicationFacade {
	
	@Autowired
	private CommunicationMapper communicationMapper;
	
	@Autowired
	private BeanFactory beanFactory;

	public CreateCommunicationResponse create(CreateCommunicationRequest request) {
		var createCommunicationUsecase = beanFactory.getBean(CreateCommunicationUsecase.class);
		var communication = communicationMapper.requestToEntity(request);
		communication = createCommunicationUsecase.create(communication);
		return communicationMapper.entityToResponse(communication);
	}
	
}
