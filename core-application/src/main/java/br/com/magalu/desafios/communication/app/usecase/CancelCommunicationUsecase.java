package br.com.magalu.desafios.communication.app.usecase;

import br.com.magalu.desafios.communication.domain.entity.Communication;

public interface CancelCommunicationUsecase {
	Communication cancel(Long communication);
}
