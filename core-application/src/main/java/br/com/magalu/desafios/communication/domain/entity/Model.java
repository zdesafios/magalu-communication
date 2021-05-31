package br.com.magalu.desafios.communication.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model implements Validable {
	
	private List<Notification> notifications;
	
	public Model() {
		notifications = new ArrayList<>();
	}
	
	protected void addNotification(String path, String message) {
		addNotification(Notification.of(path, message));
	}
	
	protected void addNotification(Notification notification) {
		notifications.add(notification);
	}
	
	protected void addNotifications(List<Notification> notifications) {
		this.notifications.addAll(notifications);
	}
	
	public List<Notification> notifications() {
		return Collections.unmodifiableList(notifications);
	}

	@Override
	public boolean isValid() {
		return notifications.isEmpty();
	}
	
}
