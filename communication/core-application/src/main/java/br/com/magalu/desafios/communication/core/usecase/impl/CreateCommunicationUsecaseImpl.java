package br.com.magalu.desafios.communication.core.usecase.impl;

import br.com.magalu.desafios.communication.core.domain.entity.Communication;
import br.com.magalu.desafios.communication.core.exceptions.CommunicationAlreadyExistsException;
import br.com.magalu.desafios.communication.core.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.core.usecase.CreateCommunicationUsecase;

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
