package br.com.magalu.desafios.communication.app.usecase.impl;

import java.util.List;

import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.GetAllCommunicationsUsecase;
import br.com.magalu.desafios.communication.app.usecase.queries.CommunicationQueryFilter;
import br.com.magalu.desafios.communication.domain.entity.Communication;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class GetAllCommunicationsUsecaseImpl implements GetAllCommunicationsUsecase {
	
	private CommunicationRepository communicationRepository;

	@Override
	public List<Communication> getCommunications(CommunicationQueryFilter filter) {
		return communicationRepository.getAll(filter);
	}

}
