package br.com.magalu.desafios.communication.app.repository;

import java.util.List;

import br.com.magalu.desafios.communication.app.usecase.queries.CommunicationQueryFilter;
import br.com.magalu.desafios.communication.domain.entity.Communication;

public interface CommunicationRepository {
	void add(Communication communication);
	boolean contains(Communication communication);
	List<Communication> getAll(CommunicationQueryFilter filter);
	Communication getById(Long id);
}
