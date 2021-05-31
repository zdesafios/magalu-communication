package br.com.magalu.desafios.communication.domain.element;

import br.com.magalu.desafios.communication.domain.validator.EmailContentValidator;
import br.com.magalu.desafios.communication.domain.validator.EmailFormatValidator;
import br.com.magalu.desafios.communication.domain.validator.SMSContentValidator;
import br.com.magalu.desafios.communication.domain.validator.MobilePhoneFormatValidator;
import br.com.magalu.desafios.communication.domain.validator.WhatsappFormatValidator;
import br.com.magalu.desafios.communication.domain.validator.WhatsappContentValidator;
import br.com.magalu.desafios.communication.domain.validator.SubscriptionContentValidator;
import br.com.magalu.desafios.communication.domain.validator.SubscriptionFormatValidator;
import br.com.magalu.desafios.communication.domain.validator.ValidatorStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommunicationType {
	EMAIL(new EmailFormatValidator(), new EmailContentValidator()),
	SMS(new MobilePhoneFormatValidator(), new SMSContentValidator()),
	PUSH(new SubscriptionFormatValidator(), new SubscriptionContentValidator()),
	WHATSAPP(new WhatsappFormatValidator(), new WhatsappContentValidator());
	
	private ValidatorStrategy formatValidator;
	private ValidatorStrategy contentValidator;
	
}
