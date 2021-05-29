package br.com.magalu.desafios.communication.app.usecase.impl;

import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.CreateCommunicationUsecase;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommunicationUsecaseFactory {
	
	public CreateCommunicationUsecase loadCreateCommunication(CommunicationRepository repository) {
		return new CreateCommunicationUsecaseImpl(repository);
	}
	
}
