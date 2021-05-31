package br.com.magalu.desafios.communication.api.web.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;

@Getter
public class CreateCommunicationRequest {
	@NotBlank
	private String type;
	
	@NotBlank
	private String content;
	
	@NotBlank
	private String destination;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime when;
}
