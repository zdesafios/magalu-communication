package br.com.magalu.desafios.communication.app.usecase.impl;

import br.com.magalu.desafios.communication.app.exceptions.CommunicationNotFoundException;
import br.com.magalu.desafios.communication.app.exceptions.InvalidCommunicationException;
import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.CancelCommunicationUsecase;
import br.com.magalu.desafios.communication.domain.entity.Communication;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class CancelCommunicationUsecaseImpl implements CancelCommunicationUsecase {
	private CommunicationRepository communicationRepository;
	
	@Override
	public Communication cancel(Long communicationId) {
		var communication = communicationRepository.getById(communicationId);
		
		if(null == communication) {
			throw new CommunicationNotFoundException(communicationId);
		}
		
		communication.markAsCanceled();
		
		if(!communication.isValid()) {
			throw new InvalidCommunicationException(communication.notifications());
		}
		
		communicationRepository.add(communication);
		
		return communication;
	}

}
