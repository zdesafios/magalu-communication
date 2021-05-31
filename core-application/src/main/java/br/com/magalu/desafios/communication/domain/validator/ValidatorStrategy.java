package br.com.magalu.desafios.communication.domain.validator;

public interface ValidatorStrategy<T> {
	boolean isValid(T value);
}
