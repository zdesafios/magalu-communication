package br.com.magalu.desafios.communication.app.usecase;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import br.com.magalu.desafios.communication.app.exceptions.CommunicationAlreadyExistsException;
import br.com.magalu.desafios.communication.app.exceptions.IvalidCommunicationException;
import br.com.magalu.desafios.communication.app.usecase.impl.CommunicationUsecaseFactory;
import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.domain.entity.Communication;
import br.com.magalu.desafios.communication.support.ListCommunicationRepository;

@Tag("fast")
@Tag("usecase")
class CreateCommunicationUsecaseTest {
	
	private CreateCommunicationUsecase createCommunicationUsecase;
	
	@BeforeEach
	void beforeEach() {
		createCommunicationUsecase = CommunicationUsecaseFactory.loadCreateCommunication(new ListCommunicationRepository());
	}

	@Test
	@DisplayName("Criar comunicado com sucesso")
	void createWithSuccess() {
		var communication = new Communication(CommunicationType.EMAIL);
		communication.setContent("Conteudo válido");
		communication.setDestination("email@domain.com.br");
		communication.setWhen(LocalDateTime.now().plusDays(1));
		communication = createCommunicationUsecase.create(communication);
		
		assertNotNull(communication.getId(), "Comunicado deve ter um ID, indicando que foi gravado na base");
	}
	
	@Test
	@DisplayName("Deve tentar criar comunicado que já existe")
	void attemptyCreateAlreadyExists() {
		var communication = new Communication(CommunicationType.EMAIL);
		communication.setContent("Conteudo válido");
		communication.setDestination("email@domain.com.br");
		communication.setWhen(LocalDateTime.now().plusDays(1));
		createCommunicationUsecase.create(communication);
		
		assertThrows(CommunicationAlreadyExistsException.class, ()-> createCommunicationUsecase.create(communication));
	}
	
	@Test
	@DisplayName("Deve tentar criar comunicado inválido")
	void attemptCreateInvalidCommunication() {
		var communication = new Communication(CommunicationType.EMAIL);
		communication.setDestination("@gmail.com");
		
		assertThrows(IvalidCommunicationException.class, ()-> createCommunicationUsecase.create(communication));
	}
	
}
