package br.com.magalu.desafios.communication.core.repository;

import br.com.magalu.desafios.communication.core.domain.entity.Communication;

public interface CommunicationRepository {
	void add(Communication communication);
	boolean contains(Communication communication);
}
