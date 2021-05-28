package br.com.magalu.desafios.communication.domain.element;

import br.com.magalu.desafios.communication.domain.validator.EmailContentValidator;
import br.com.magalu.desafios.communication.domain.validator.EmailFormatValidator;
import br.com.magalu.desafios.communication.domain.validator.MobilePhoneContentValidator;
import br.com.magalu.desafios.communication.domain.validator.MobilePhoneFormatValidator;
import br.com.magalu.desafios.communication.domain.validator.WhathsappContentValidator;
import br.com.magalu.desafios.communication.domain.validator.SubscriptionContentValidator;
import br.com.magalu.desafios.communication.domain.validator.SubscriptionFormatValidator;
import br.com.magalu.desafios.communication.domain.validator.ValidatorStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommunicationType {
	EMAIL(new EmailFormatValidator(), new EmailContentValidator()),
	SMS(new MobilePhoneFormatValidator(), new MobilePhoneContentValidator()),
	PUSH(new SubscriptionFormatValidator(), new SubscriptionContentValidator()),
	WHATSAPP(new MobilePhoneFormatValidator(), new WhathsappContentValidator());
	
	private ValidatorStrategy formatValidator;
	private ValidatorStrategy contentValidator;
	
}
