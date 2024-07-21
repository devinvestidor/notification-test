package br.com.devinvestidor.notification.response;

import org.springframework.http.HttpStatus;


public class ResponseBuilder {
    private HttpStatus httpStatus;
    private String message = "";
    private MessageType messageType = MessageType.INFO;
    private Object body;

    public ResponseBuilder setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseBuilder setMessageType(MessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public ResponseBuilder setBody(Object body) {
        this.body = body;
        return this;
    }

    public Response build() {
        return new Response(httpStatus, message, messageType, body);
    }
}