package br.com.magalu.desafios.communication.core.usecase.impl;

import br.com.magalu.desafios.communication.core.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.core.usecase.CreateCommunicationUsecase;

public class CommunicationUsecaseFactory {
	private CommunicationUsecaseFactory() {}
	
	public static final CreateCommunicationUsecase loadCreateCommunication(CommunicationRepository repository) {
		return new CreateCommunicationUsecaseImpl(repository);
	}
	
}
