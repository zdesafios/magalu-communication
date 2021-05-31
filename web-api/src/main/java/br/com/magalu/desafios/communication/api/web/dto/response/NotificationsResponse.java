package br.com.magalu.desafios.communication.api.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotificationsResponse {
	private String path;
	private String message;
}
