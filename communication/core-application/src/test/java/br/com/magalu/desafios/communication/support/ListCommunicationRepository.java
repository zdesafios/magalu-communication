package br.com.magalu.desafios.communication.support;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.magalu.desafios.communication.app.repository.CommunicationRepository;
import br.com.magalu.desafios.communication.domain.entity.Communication;

public class ListCommunicationRepository implements CommunicationRepository {
	private List<Communication> communications = new ArrayList<>();

	@Override
	public void add(Communication communication) {
		try {
			Field field = Communication.class.getDeclaredField("id");
			field.setAccessible(true);
			field.set(communication, "1");
			field.setAccessible(false);
			communications.add(communication);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean contains(Communication communication) {
		return communications.contains(communication);
	}

}
