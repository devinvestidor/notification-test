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

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SmsSenderNotificationServiceImplTest {
    @Spy
    @InjectMocks
    private SmsSenderNotificationServiceImpl smsSenderNotificationService;

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
        smsSenderNotificationService.send(dto);
        verify(smsSenderNotificationService, times(1)).failProcess(eq(dto), eq(user), eq(Channel.SMS));
    }

    @Test
    public void testSendCallsSendProcess() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotPhoneNumber()).thenReturn(false);
        smsSenderNotificationService.send(dto);
        verify(smsSenderNotificationService, times(1)).sendProcess(eq(dto), eq(user));
    }

    @Test
    public void testSendProcessThrowsException() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        doThrow(new RuntimeException("Error")).when(smsSenderNotificationService).sendProcess(eq(dto), eq(user));
        smsSenderNotificationService.send(dto);
        verify(smsSenderNotificationService, times(1)).failProcess(eq(dto), eq(user), eq(Channel.SMS));
    }

    @Test
    public void testSendProcessCallsLogServiceOnSuccess() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotPhoneNumber()).thenReturn(false);

        smsSenderNotificationService.sendProcess(dto, user);

        verify(logService, times(1)).save(any());
    }
}
