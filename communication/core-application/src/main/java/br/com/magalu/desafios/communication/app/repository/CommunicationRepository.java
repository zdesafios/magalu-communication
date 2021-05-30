package br.com.magalu.desafios.communication.app.repository;

import br.com.magalu.desafios.communication.domain.entity.Communication;

public interface CommunicationRepository {
	void add(Communication communication);
	boolean contains(Communication communication);
}
