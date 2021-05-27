package br.com.magalu.desafios.communication.core.usecase;

import br.com.magalu.desafios.communication.core.domain.entity.Communication;

public interface CreateCommunicationUsecase {
	Communication create(Communication communication);
}
