package br.com.devinvestidor.notification.controller;


import br.com.devinvestidor.notification.exception.NoContentException;
import br.com.devinvestidor.notification.response.HttpResponse;
import br.com.devinvestidor.notification.response.Response;
import java.util.List;


public class Controller {

    protected Response ok(String msg) {
        return HttpResponse.ok(msg);
    }

    public Response okList(List<?> list) {
        if (list.size() == 0) throw new NoContentException();
        else return HttpResponse.ok(list,  null);
    }
}