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

public class EmailSenderNotificationServiceImplTest {
    @Spy
    @InjectMocks
    private EmailSenderNotificationServiceImpl emailSenderNotificationService;

    @Mock
    private LogService logService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendThrowsWithoutEmailException() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotEmail()).thenReturn(true);
        emailSenderNotificationService.send(dto);
        verify(emailSenderNotificationService, times(1)).failProcess(eq(dto), eq(user), eq(Channel.EMAIL));
    }

    @Test
    public void testSendCallsSendProcess() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotPhoneNumber()).thenReturn(false);
        emailSenderNotificationService.send(dto);
        verify(emailSenderNotificationService, times(1)).sendProcess(eq(dto), eq(user));
    }

    @Test
    public void testSendProcessThrowsException() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        doThrow(new RuntimeException("Error")).when(emailSenderNotificationService).sendProcess(eq(dto), eq(user));
        emailSenderNotificationService.send(dto);
        verify(emailSenderNotificationService, times(1)).failProcess(eq(dto), eq(user), eq(Channel.EMAIL));
    }

    @Test
    public void testSendProcessCallsLogServiceOnSuccess() {
        User user = mock(User.class);
        NotificationDTO dto = new NotificationDTO(null, "test", Collections.singletonList(user));

        when(user.hasNotPhoneNumber()).thenReturn(false);

        emailSenderNotificationService.sendProcess(dto, user);

        verify(logService, times(1)).save(any());
    }

}
