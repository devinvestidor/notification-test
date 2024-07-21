package br.com.devinvestidor.notification.controller;

import br.com.devinvestidor.notification.dto.NotificationDTO;
import br.com.devinvestidor.notification.response.Response;
import br.com.devinvestidor.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController extends Controller{

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Response send(@RequestBody NotificationDTO dto) {
        notificationService.sendNotification(dto);
        return ok("Notifications being processed...");
    }
}
