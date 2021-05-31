package br.com.magalu.desafios.communication.api.facade;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magalu.desafios.communication.api.mapper.CommunicationMapper;
import br.com.magalu.desafios.communication.api.web.dto.CommunicationResume;
import br.com.magalu.desafios.communication.api.web.dto.request.CreateCommunicationRequest;
import br.com.magalu.desafios.communication.api.web.dto.request.GetCommunicationsRequestQuery;
import br.com.magalu.desafios.communication.api.web.dto.response.CreateCommunicationResponse;
import br.com.magalu.desafios.communication.app.usecase.CreateCommunicationUsecase;
import br.com.magalu.desafios.communication.app.usecase.GetAllCommunicationsUsecase;

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
	
	public List<CommunicationResume> list(GetCommunicationsRequestQuery request) {
		var getAllCommunicationsUsecase = beanFactory.getBean(GetAllCommunicationsUsecase.class);
		var filter = communicationMapper.requestToFilter(request); 
			
		return communicationMapper.entitiesToResume(getAllCommunicationsUsecase.getCommunications(filter));
	}

	public CommunicationResume attemptCancelCommunication(Long communication) {
		return null;
	}
	
}
