package br.com.devinvestidor.notification.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class Response {
    private int status;
    private String message;
    private boolean error;
    private Object body;

    public Response(HttpStatus httpStatus, String message, boolean error, Object body) {
        this.status = httpStatus.value();
        this.message = message;
        this.error = error;
        this.body = body;
    }
}