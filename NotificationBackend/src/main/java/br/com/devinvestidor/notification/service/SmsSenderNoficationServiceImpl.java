package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dto.NotificationDTO;
import br.com.devinvestidor.notification.entity.Log;
import br.com.devinvestidor.notification.entity.Channel;
import br.com.devinvestidor.notification.entity.StatusNotification;
import br.com.devinvestidor.notification.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("smsSenderNofication")
public class SmsSenderNoficationServiceImpl extends SenderNotificationService {


    @Override
    public void send(NotificationDTO dto) {
        dto.getUserList().forEach(user -> {
            try {
                if (user.hasNotPhoneNumber()) throw new Exception("dont have phone");
                else sendProcess(dto, user);
            } catch (Exception e) {
                failProcess(dto, user, Channel.SMS);
            }
        });
    }

    @Override
    public void sendProcess(NotificationDTO dto, User user) {
        try {
            // some Implement here to send...
            logService.save(getLog(dto, user, Channel.SMS));
        } catch (Exception e) {
            failProcess(dto, user, Channel.SMS);
        }
    }


}
