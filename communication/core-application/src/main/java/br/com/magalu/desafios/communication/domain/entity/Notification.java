package br.com.magalu.desafios.communication.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notification {
	private String path;
	private String message;

	public static Notification of(String path, String message) {
		return new Notification(path, message);
	}

}
