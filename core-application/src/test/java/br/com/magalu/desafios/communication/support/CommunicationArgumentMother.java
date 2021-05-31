package br.com.magalu.desafios.communication.support;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import com.github.javafaker.Faker;

import br.com.magalu.desafios.communication.domain.element.CommunicationType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommunicationArgumentMother {
	
	public Stream<Arguments> argumentsForValidCommunication() {
		Faker faker = new Faker();
	    return Stream.of(
            Arguments.of(CommunicationType.EMAIL, faker.internet().emailAddress(), faker.lorem().characters(160)),
            Arguments.of(CommunicationType.EMAIL, faker.internet().emailAddress(), faker.lorem().characters(10)),
            
            Arguments.of(CommunicationType.PUSH, UUID.randomUUID().toString(), faker.lorem().characters(160)),
            Arguments.of(CommunicationType.PUSH, UUID.randomUUID().toString(), faker.lorem().characters(10)),
            
            Arguments.of(CommunicationType.SMS, "+5581999995555", faker.lorem().characters(160)),
            Arguments.of(CommunicationType.SMS, "+558199999555", faker.lorem().characters(10)),
            
            Arguments.of(CommunicationType.WHATSAPP, "+5581999995555", faker.lorem().characters(160)),
            Arguments.of(CommunicationType.WHATSAPP, "+558199999555", faker.lorem().characters(10))
	    );
	}
	
	public Stream<Arguments> argumentsForPresentAndFutureDate() {
		LocalDateTime dateTime = null;
		return Stream.of(
			Arguments.of(dateTime),
            Arguments.of(LocalDateTime.now()),
            Arguments.of(LocalDateTime.now().minusMinutes(1))
        );
	}
	
	public Stream<Arguments> argumentsForInvalidContent() {
		Faker faker = new Faker();
	    return Stream.of(
            Arguments.of(CommunicationType.EMAIL, faker.lorem().characters(0)),
            Arguments.of(CommunicationType.EMAIL, null),
            Arguments.of(CommunicationType.EMAIL, "   "),
            Arguments.of(CommunicationType.EMAIL, faker.lorem().characters(50001)),
            
            Arguments.of(CommunicationType.PUSH, faker.lorem().characters(0)),
            Arguments.of(CommunicationType.PUSH, null),
            Arguments.of(CommunicationType.PUSH, "   "),
            Arguments.of(CommunicationType.PUSH, faker.lorem().characters(1000)),
            
            Arguments.of(CommunicationType.SMS, faker.lorem().characters(0)),
            Arguments.of(CommunicationType.SMS, null),
            Arguments.of(CommunicationType.SMS, "   "),
            Arguments.of(CommunicationType.SMS, faker.lorem().characters(1000)),
            
            Arguments.of(CommunicationType.WHATSAPP, faker.lorem().characters(0)),
            Arguments.of(CommunicationType.WHATSAPP, null),
            Arguments.of(CommunicationType.WHATSAPP, "   "),
            Arguments.of(CommunicationType.WHATSAPP, faker.lorem().characters(4001))
	    );
	}
	
	public Stream<Arguments> argumentsForInvalidDestination() {
		Faker faker = new Faker();
	    return Stream.of(
            Arguments.of(CommunicationType.EMAIL, faker.pokemon().name()),
            Arguments.of(CommunicationType.EMAIL, null),
            Arguments.of(CommunicationType.EMAIL, "   "),
            Arguments.of(CommunicationType.EMAIL, "email@"),
            Arguments.of(CommunicationType.EMAIL, "@gmail.com"),
            
            Arguments.of(CommunicationType.PUSH, "11111111-1111-1111-1111-11111111111G"),
            Arguments.of(CommunicationType.PUSH, null),
            Arguments.of(CommunicationType.PUSH, "   "),
            Arguments.of(CommunicationType.PUSH, "11111111-1111-1111-1111-11111111111"),
            
            Arguments.of(CommunicationType.SMS, "(11) 99999-2212"),
            Arguments.of(CommunicationType.SMS, null),
            Arguments.of(CommunicationType.SMS, "   "),
            Arguments.of(CommunicationType.SMS, "+55 11 99999-2212"),
            
            Arguments.of(CommunicationType.WHATSAPP, "(11) 99999-2212"),
            Arguments.of(CommunicationType.WHATSAPP, null),
            Arguments.of(CommunicationType.WHATSAPP, "   "),
            Arguments.of(CommunicationType.WHATSAPP, "+55 11 99999-2212")
	    );
	}
}
