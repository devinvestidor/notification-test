package br.com.devinvestidor.notification.controller;

import br.com.devinvestidor.notification.response.Response;
import br.com.devinvestidor.notification.response.HttpResponse;
import br.com.devinvestidor.notification.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public Response listAll() {
        return HttpResponse.sucess(logService.listAll(), "");
    }

}