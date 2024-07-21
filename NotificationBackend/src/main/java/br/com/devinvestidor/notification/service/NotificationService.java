package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dto.NotificationDTO;

public interface NotificationService {

    void sendNotification(NotificationDTO dto);
}
