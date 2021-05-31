package br.com.magalu.desafios.communication.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.app.usecase.CreateCommunicationUsecase;
import br.com.magalu.desafios.communication.app.usecase.impl.CommunicationUsecaseFactory;

@Configuration
public class CommunicationConfiguration {

	@Bean
	@Scope("prototype")
	public CreateCommunicationUsecase createCommunicationUsecase(@Autowired CommunicationRepository repository) {
		return CommunicationUsecaseFactory.loadCreateCommunication(repository);
	}
	
}
