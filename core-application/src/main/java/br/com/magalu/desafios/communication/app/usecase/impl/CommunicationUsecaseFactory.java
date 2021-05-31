package br.com.magalu.desafios.communication.app.usecase.impl;

import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.CreateCommunicationUsecase;
import br.com.magalu.desafios.communication.app.usecase.GetAllCommunicationsUsecase;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommunicationUsecaseFactory {
	
	public CreateCommunicationUsecase loadCreateCommunication(CommunicationRepository repository) {
		return new CreateCommunicationUsecaseImpl(repository);
	}
	
	public GetAllCommunicationsUsecase loadGetAllCommunications(CommunicationRepository repository) {
		return new GetAllCommunicationsUsecaseImpl(repository);
	}
	
}
