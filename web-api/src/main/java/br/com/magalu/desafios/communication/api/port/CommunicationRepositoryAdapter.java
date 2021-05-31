package br.com.magalu.desafios.communication.api.port;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magalu.desafios.communication.api.repository.CommunicationJPARepository;
import br.com.magalu.desafios.communication.api.repository.specification.CommunicationSpeficification;
import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.queries.CommunicationQueryFilter;
import br.com.magalu.desafios.communication.domain.entity.Communication;

@Component
public class CommunicationRepositoryAdapter implements CommunicationRepository {
	
	@Autowired
	private CommunicationJPARepository communicationRepository;
	
	
	@Override
	public void add(Communication communication) {
		communicationRepository.save(communication);
	}

	@Override
	public boolean contains(Communication communication) {
		return communicationRepository.existsByContentAndTypeAndDestination(communication.getContent(), communication.getType(), communication.getDestination());
	}

	@Override
	public List<Communication> getAll(CommunicationQueryFilter filter) {
		return communicationRepository.findAll(CommunicationSpeficification.getAll(filter));
	}

	@Override
	public Communication getById(Long id) {
		return communicationRepository.findById(id).orElse(null);
	}

}
