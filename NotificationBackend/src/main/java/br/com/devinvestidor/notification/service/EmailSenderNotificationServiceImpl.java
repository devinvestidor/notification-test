package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dto.NotificationDTO;
import br.com.devinvestidor.notification.entity.Channel;
import br.com.devinvestidor.notification.entity.User;
import br.com.devinvestidor.notification.exception.WithoutEmailException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailSenderNofication")
public class EmailSenderNotificationServiceImpl extends SenderNotificationService {
    public void send(NotificationDTO dto) {
        dto.getUserList().forEach(user -> {
            try {
                if (user.hasNotEmail()) throw new WithoutEmailException();
                else sendProcess(dto, user);
            } catch (Exception e) {
                failProcess(dto, user, Channel.EMAIL);
            }
        });
    }

    @Override
    public void sendProcess(NotificationDTO dto, User user) {
        try {
            // some Implement here to send...
            logService.save(getLog(dto, user, Channel.EMAIL));
        } catch (Exception e) {
            failProcess(dto, user, Channel.EMAIL);
        }
    }
}
