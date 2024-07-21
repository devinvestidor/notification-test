package br.com.devinvestidor.notification.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class Response {
    private int status;
    private String message;
    private MessageType messageType;
    private Object body;

    public Response(HttpStatus httpStatus, String message, MessageType messageType, Object body) {
        this.status = httpStatus.value();
        this.message = message;
        this.messageType = messageType;
        this.body = body;
    }
}