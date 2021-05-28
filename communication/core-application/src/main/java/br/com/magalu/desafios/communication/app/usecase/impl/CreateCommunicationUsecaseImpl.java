package br.com.magalu.desafios.communication.app.usecase.impl;

import br.com.magalu.desafios.communication.app.exceptions.CommunicationAlreadyExistsException;
import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.CreateCommunicationUsecase;
import br.com.magalu.desafios.communication.domain.entity.Communication;

class CreateCommunicationUsecaseImpl implements CreateCommunicationUsecase {
	private CommunicationRepository communicationRepository;
	
	public CreateCommunicationUsecaseImpl(CommunicationRepository communicationRepository) {
		this.communicationRepository = communicationRepository;
	}

	@Override
	public Communication create(Communication communication) {
		
		if(communicationRepository.contains(communication)) {
			throw new CommunicationAlreadyExistsException();
		}
		
		communicationRepository.add(communication);
		
		return communication;
	}

}
