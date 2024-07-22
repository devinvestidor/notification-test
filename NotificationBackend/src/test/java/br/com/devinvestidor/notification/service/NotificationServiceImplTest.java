package br.com.devinvestidor.notification.service;


import br.com.devinvestidor.notification.dto.NotificationDTO;
import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.Channel;
import br.com.devinvestidor.notification.entity.User;
import br.com.devinvestidor.notification.exception.WithoutCategoryException;
import br.com.devinvestidor.notification.exception.WithoutDescriptionException;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class NotificationServiceImplTest {
    @InjectMocks
    private NotificationServiceImpl notificationServiceImpl;


    @Test
    public void shouldThrowExceptionWhenCategoryIsNull() {
        NotificationDTO dto = new NotificationDTO(null, "test", new ArrayList<>());
        assertThrows(WithoutCategoryException.class, ()-> notificationServiceImpl.sendNotification(dto));
    }

    @Test
    public void shouldThrowExceptionWhenDescriptionIsNull() {
        NotificationDTO dto = new NotificationDTO(new Category(1L), null, new ArrayList<>());
        assertThrows(WithoutDescriptionException.class, () -> notificationServiceImpl.sendNotification(dto));
    }

    @Test
    public void shouldThrowExceptionWhenDescriptionIsEmpty() {
        NotificationDTO dto = new NotificationDTO(new Category(1L), "", new ArrayList<>());
        assertThrows(WithoutDescriptionException.class, () -> notificationServiceImpl.sendNotification(dto));
    }

    @Test
    public void shouldThrowExceptionWhenDescriptionIsBlank() {
        NotificationDTO dto = new NotificationDTO(new Category(1L), "   ", new ArrayList<>());
        assertThrows(WithoutDescriptionException.class, () -> notificationServiceImpl.sendNotification(dto));
    }

    @Test
    public void testGetListByNotificationChannel() {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setNotificationChannelList(Collections.singletonList(Channel.SMS));
        User user2 = new User();
        user2.setNotificationChannelList(Collections.singletonList(Channel.EMAIL));
        userList.add(user1);
        userList.add(user2);

        List<User> result = notificationServiceImpl.getListByNotificationChannel(userList, Channel.SMS);
        assertEquals(1, result.size());
        assertEquals(user1, result.get(0));

        result = notificationServiceImpl.getListByNotificationChannel(userList, Channel.EMAIL);
        assertEquals(1, result.size());
        assertEquals(user2, result.get(0));

        result = notificationServiceImpl.getListByNotificationChannel(userList, Channel.PUSH_NOTIFICATION);
        assertEquals(0, result.size());
    }
}