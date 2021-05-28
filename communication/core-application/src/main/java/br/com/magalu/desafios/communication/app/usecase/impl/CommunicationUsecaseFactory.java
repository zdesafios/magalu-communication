package br.com.magalu.desafios.communication.app.usecase.impl;

import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.CreateCommunicationUsecase;

public class CommunicationUsecaseFactory {
	private CommunicationUsecaseFactory() {}
	
	public static final CreateCommunicationUsecase loadCreateCommunication(CommunicationRepository repository) {
		return new CreateCommunicationUsecaseImpl(repository);
	}
	
}
