package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dto.NotificationDTO;
import br.com.devinvestidor.notification.entity.Channel;
import br.com.devinvestidor.notification.entity.User;
import br.com.devinvestidor.notification.exception.WithoutCategoryException;
import br.com.devinvestidor.notification.exception.WithoutDescriptionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    @Qualifier("smsSenderNofication")
    private SenderNotificationService smsSenderNotificationService;

    @Autowired
    @Qualifier("emailSenderNofication")
    private SenderNotificationService emailSenderNotificationService;

    @Autowired
    @Qualifier("pushSenderNofication")
    private SenderNotificationService pushSenderNotificationService;

    @Autowired
    private UserService userService;



    @Override
    public void sendNotification(NotificationDTO dto) {
        if (dto.hasNotCategory()) throw new WithoutCategoryException();
        if (dto.hasNotMessage()) throw new WithoutDescriptionException();

        List<User> userList = userService.listByCategory(dto.getCategory());

        List<User> smsUserList = getListByNotificationChannel(userList, Channel.SMS);
        List<User> emailUserList = getListByNotificationChannel(userList, Channel.EMAIL);
        List<User> pushUserList = getListByNotificationChannel(userList, Channel.PUSH_NOTIFICATION);

        sendNotificationThread(dto, smsUserList, emailUserList, pushUserList);
    }

    protected List<User> getListByNotificationChannel(List<User> userList, Channel channel) {
        List<User> listResult = new ArrayList<>();

        if (userList != null) listResult = userList.stream().filter(u-> u.getNotificationChannelList().contains(channel)).collect(Collectors.toList());

        return listResult;
    }

    private void sendNotificationThread(NotificationDTO dto, List<User> smsUserList, List<User> emailUserList, List<User> pushUserList) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> smsSenderNotificationService.send(dto.getEntityWithUserList(smsUserList)));
        executor.submit(() -> emailSenderNotificationService.send(dto.getEntityWithUserList(emailUserList)));
        executor.submit(() -> pushSenderNotificationService.send(dto.getEntityWithUserList(pushUserList)));
    }


}
