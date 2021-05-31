package br.com.magalu.desafios.communication.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import br.com.magalu.desafios.communication.support.ListCommunicationRepository;

@Tag("entity")
class CommunicationTest {

	@ParameterizedTest
	@DisplayName("Deve instanciar(Corretamente) um comunicado com conteúdo, destinatário e tipos")
	@MethodSource("br.com.magalu.desafios.communication.support.CommunicationArgumentMother#argumentsForValidCommunication")
	void validCommunication(CommunicationType type, String destination, String conteudo) {
		var communication = new Communication(type);
		communication.setContent(conteudo);
		communication.setDestination(destination);
		communication.setWhen(LocalDateTime.now().plusHours(2));
		
		assertTrue(communication.isValid(), "Deve ser um comunicado válido");
		assertTrue(communication.notifications().isEmpty(), "A Lista deve ser vazia, indicando que não houve notificações do domínio");
	}
	
	@ParameterizedTest
	@DisplayName("Deve instanciar um comunicado com conteúdo inválido de acordo com o tipo")
	@MethodSource("br.com.magalu.desafios.communication.support.CommunicationArgumentMother#argumentsForInvalidContent")
	void communicationWithInvalidContent(CommunicationType type, String conteudo) {
		var communication = new Communication(type);
		communication.setContent(conteudo);
		
		assertFalse(communication.isValid(), "Deve ser inválido");
		assertEquals( 1, communication.notifications().size(), "A Lista deve conter 1 notificação, indicando que houve violação");
	}
	
	@ParameterizedTest
	@DisplayName("Deve instanciar um comunicado com destinatário inválido de acordo com o tipo")
	@MethodSource("br.com.magalu.desafios.communication.support.CommunicationArgumentMother#argumentsForInvalidDestination")
	void communicationWithInvalidDestination(CommunicationType type, String destination) {
		var communication = new Communication(type);
		communication.setDestination(destination);
		
		assertFalse(communication.isValid(), "Deve ser inválido");
		assertEquals( 1, communication.notifications().size(), "A Lista deve conter 1 notificação, indicando que houve violação");
	}
	
	@ParameterizedTest
	@DisplayName("Deve instanciar um comunicado com data no presente e passado")
	@MethodSource("br.com.magalu.desafios.communication.support.CommunicationArgumentMother#argumentsForPresentAndFutureDate")
	void communicationWithPresentAndFutureDate(LocalDateTime when) {
		var communication = new Communication(CommunicationType.EMAIL);
		communication.setWhen(when);
		
		assertFalse(communication.isValid(), "Deve ser invádilo");
		assertEquals( 1, communication.notifications().size(), "A Lista deve conter 1 notificação, indicando que houve violação");
		assertEquals("'when' needs to be in the future", communication.notifications().get(0).getMessage());
	}
	
	@Test
	@DisplayName("Deve instanciar um comunicado com status pendente")
	void needsToBePending() {
		var communication = new Communication(CommunicationType.EMAIL);
		
		assertTrue(communication.isValid(), "Deve ser válido");
		assertTrue(communication.isPending(), "Deve ser Pendente");
		assertTrue(communication.notifications().isEmpty(), "A Lista deve ser vazia, indicando que não houve violação");
	}
	
	@Test
	@DisplayName("Deve nascer pendente, não pode mudar pra sent um objeto novo")
	void attemptChangeStatusForSent() {
		var communication = new Communication(CommunicationType.EMAIL);
		communication.markAsSent();
		
		assertFalse(communication.isValid(), "Deve ser inválido");
		assertTrue(communication.isPending(), "Deve ser continuar Pendente");
		assertEquals(1, communication.notifications().size(), "A Lista deve conter 1 notificação, indicando que houve violação");
	}
	
	@Test
	@DisplayName("Não pode editar depois de enviado")
	void attemptChangePropertiesWithStatusSent() {
		var communication = new Communication(CommunicationType.EMAIL);
		
		var repo = new ListCommunicationRepository();
		repo.add(communication);
		
		communication.markAsSent();
		
		communication.setWhen(LocalDateTime.now());
		communication.setContent("Conteudo válido");
		communication.setDestination("as@gmail.com");
		
		assertFalse(communication.isValid(), "Deve ser Pendnte");
		assertEquals(3, communication.notifications().size(), "A Lista deve ser vazia, indicando que não houve notificações");
		assertEquals("'when' not updated, because the communication has already been sent", communication.notifications().get(0).getMessage());
		assertEquals("'content' not updated, because the communication has already been sent", communication.notifications().get(1).getMessage());
		assertEquals("'destination' not updated, because the communication has already been sent", communication.notifications().get(2).getMessage());
	}
	
	
	
	
	
	
}
