package br.com.magalu.desafios.communication.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Communication;
import br.com.magalu.desafios.communication.domain.vo.Content;
import br.com.magalu.desafios.communication.domain.vo.Destination;

@Repository
public interface CommunicationJPARepository extends JpaRepository<Communication, Long> {
	
	@Query
	public boolean existsByContentAndTypeAndDestination(Content content, CommunicationType type, Destination destination);

}
