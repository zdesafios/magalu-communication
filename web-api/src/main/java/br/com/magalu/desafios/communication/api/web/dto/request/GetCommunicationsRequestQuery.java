package br.com.magalu.desafios.communication.api.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetCommunicationsRequestQuery {
	private String type;
	private String destination;
	private String when;
}
