package br.com.devinvestidor.notification.response;

import org.springframework.http.HttpStatus;

public class HttpResponse {


    public static Response sucess(String message) {
        return sucess(null, message);
    }
    public static Response sucess(Object body, String message) {
        return new ResponseBuilder()
                .setStatusCode(HttpStatus.OK)
                .setMessage(message)
                .setBody(body)
                .build();
    }

}
