package br.com.magalu.desafios.communication.api.repository.specification;

import static org.springframework.data.jpa.domain.Specification.where;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import br.com.magalu.desafios.communication.app.usecase.queries.CommunicationQueryFilter;
import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Communication;
import br.com.magalu.desafios.communication.domain.vo.Destination;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommunicationSpeficification {

	public Specification<Communication> byType(CommunicationType type) {
		return ( root, criteriaQuery, criteriaBuilder ) -> {
            if( null == type ) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal( root.get( "type" ), type );
        };
	}
	
	public Specification<Communication> byDestination(Destination destination) {
		return ( root, criteriaQuery, criteriaBuilder ) -> {
            if( null == destination || null == destination.getRecipient() || destination.getRecipient().isBlank() ) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal( root.get( "destination" ), destination );
        };
	}
	
	public Specification<Communication> byWhen(LocalDateTime when) {
		return ( root, criteriaQuery, criteriaBuilder ) -> {
            if( null == when ) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal( root.get( "when" ), when );
        };
	}

	public Specification<Communication> getAll(CommunicationQueryFilter filter) {
		return where(byType(filter.getType()))
				.and(byDestination(filter.getDestination()))
				.and(byWhen(filter.getWhen()));
	}
	
}
