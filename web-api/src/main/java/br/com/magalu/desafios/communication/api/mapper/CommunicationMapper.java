package br.com.magalu.desafios.communication.api.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.magalu.desafios.communication.api.web.dto.CommunicationResume;
import br.com.magalu.desafios.communication.api.web.dto.request.CreateCommunicationRequest;
import br.com.magalu.desafios.communication.api.web.dto.request.GetCommunicationsRequestQuery;
import br.com.magalu.desafios.communication.api.web.dto.response.CreateCommunicationResponse;
import br.com.magalu.desafios.communication.app.usecase.queries.CommunicationQueryFilter;
import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Communication;
import br.com.magalu.desafios.communication.domain.vo.Destination;

@Component
public class CommunicationMapper {
	private final static DateTimeFormatter DATATIME_FORMATTER = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" );

	public Communication requestToEntity(CreateCommunicationRequest request) {
		var type = CommunicationType.fromNameOrNull(request.getType());
		var communication = new Communication(type);
		communication.setContent(request.getContent());
		communication.setDestination(request.getDestination());
		communication.setWhen(LocalDateTime.parse(request.getWhen(), DATATIME_FORMATTER));
		
		return communication;
	}

	public CreateCommunicationResponse entityToResponse(Communication communication) {
		return new CreateCommunicationResponse(communication.getId());
	}

	public List<CommunicationResume> entitiesToResume(List<Communication> communications) {
		return communications.stream()
				.map(c-> new CommunicationResume(c.getType().name(), c.getDestination().getRecipient(), c.getContent().getText(), c.getWhen().format(DATATIME_FORMATTER)))
				.collect(Collectors.toList());
	}

	public CommunicationQueryFilter requestToFilter(GetCommunicationsRequestQuery request) {
		return CommunicationQueryFilter.builder()
				.type(CommunicationType.fromNameOrNull(request.getType()))
				.destination(new Destination(request.getDestination(), CommunicationType.fromNameOrNull(request.getType())))
				.when(null!=request.getWhen()?LocalDateTime.parse(request.getWhen(), DATATIME_FORMATTER): null)
				.build();
	}

}
