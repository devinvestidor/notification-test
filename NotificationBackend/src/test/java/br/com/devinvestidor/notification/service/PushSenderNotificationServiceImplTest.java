package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dto.NotificationDTO;
import br.com.devinvestidor.notification.entity.Channel;
import br.com.devinvestidor.notification.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.mockito.Mockito.*;

@SpringBootTest
public class PushSenderNotificationServiceImplTest {
    @Spy
    @InjectMocks
    private PushSenderNotificationServiceImpl pushSenderNotificationService;

    @Mock
    private LogService logService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendThrowsWithoutPhoneException() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotPhoneNumber()).thenReturn(true);
        pushSenderNotificationService.send(dto);
        verify(pushSenderNotificationService, times(1)).failProcess(eq(dto), eq(user), eq(Channel.PUSH_NOTIFICATION));
    }

    @Test
    public void testSendCallsSendProcess() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotPhoneNumber()).thenReturn(false);
        pushSenderNotificationService.send(dto);
        verify(pushSenderNotificationService, times(1)).sendProcess(eq(dto), eq(user));
    }

    @Test
    public void testSendProcessThrowsException() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        doThrow(new RuntimeException("Error")).when(pushSenderNotificationService).sendProcess(eq(dto), eq(user));
        pushSenderNotificationService.send(dto);
        verify(pushSenderNotificationService, times(1)).failProcess(eq(dto), eq(user), eq(Channel.PUSH_NOTIFICATION));
    }

    @Test
    public void testSendProcessCallsLogServiceOnSuccess() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotPhoneNumber()).thenReturn(false);

        pushSenderNotificationService.sendProcess(dto, user);

        verify(logService, times(1)).save(any());
    }
}
