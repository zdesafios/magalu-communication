package br.com.magalu.desafios.communication.app.usecase.queries;

import java.time.LocalDateTime;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.vo.Destination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommunicationQueryFilter {
	private CommunicationType type;
	private Destination destination;
	private LocalDateTime when;
}
