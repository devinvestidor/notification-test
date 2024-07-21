package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dto.NotificationDTO;
import br.com.devinvestidor.notification.entity.Channel;
import br.com.devinvestidor.notification.entity.Log;
import br.com.devinvestidor.notification.entity.StatusNotification;
import br.com.devinvestidor.notification.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public abstract class SenderNotificationService {

    @Autowired
    protected LogService logService;

    abstract void send(NotificationDTO dto);
    abstract void sendProcess(NotificationDTO dto, User user);

    void failProcess(NotificationDTO dto, User user, Channel channel) {
        Log log = getLog(dto, user, channel);
        log.setStatusNotification(StatusNotification.ERROR);

        logService.save(log);
    }

    Log getLog(NotificationDTO dto, User user, Channel channel) {
        Log log = new Log();
        log.setCategory(dto.getCategory());
        log.setChannel(channel);
        log.setUser(user);
        log.setDateSent(new Date());
        log.setStatusNotification(StatusNotification.OK);

        return log;
    }
}
