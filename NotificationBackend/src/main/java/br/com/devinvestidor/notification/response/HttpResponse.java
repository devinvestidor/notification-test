package br.com.devinvestidor.notification.response;

import org.springframework.http.HttpStatus;

public class HttpResponse {


    public static Response ok(String message) {
        return ok(null, message);
    }
    public static Response ok(Object body, String message) {
        return new ResponseBuilder()
                .setHttpStatus(HttpStatus.OK)
                .setMessage(message)
                .setMessageType(MessageType.INFO)
                .setBody(body)
                .build();
    }

    public static Response noContent() {
        return new ResponseBuilder()
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .setMessageType(MessageType.INFO)
                .build();
    }

    public static Response success(Object body, String message) {
        return new ResponseBuilder()
                .setHttpStatus(HttpStatus.OK)
                .setMessage(message)
                .setMessageType(MessageType.SUCCESS)
                .setBody(body)
                .build();
    }

    public static Response warning(HttpStatus httpStatus, String message) {
        return new ResponseBuilder()
                .setHttpStatus(httpStatus)
                .setMessage(message)
                .setMessageType(MessageType.WARNING)
                .build();
    }

    public static Response error(HttpStatus httpStatus, String message) {
        return new ResponseBuilder()
                .setHttpStatus(httpStatus)
                .setMessage(message)
                .setMessageType(MessageType.ERROR)
                .build();
    }
}
