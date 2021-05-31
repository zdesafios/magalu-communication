package br.com.magalu.desafios.communication.app.usecase;

import java.util.List;

import br.com.magalu.desafios.communication.app.usecase.queries.CommunicationQueryFilter;
import br.com.magalu.desafios.communication.domain.entity.Communication;

public interface GetAllCommunicationsUsecase {
	List<Communication> getCommunications(CommunicationQueryFilter filter);
}
