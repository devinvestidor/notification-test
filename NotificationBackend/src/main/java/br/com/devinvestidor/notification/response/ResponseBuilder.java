package br.com.devinvestidor.notification.response;

import org.springframework.http.HttpStatus;


public class ResponseBuilder {
    private HttpStatus httpStatus;
    private String message = "";
    private boolean error = false;
    private Object body;

    public ResponseBuilder setStatusCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseBuilder setError(boolean error) {
        this.error = error;
        return this;
    }

    public ResponseBuilder setBody(Object body) {
        this.body = body;
        return this;
    }

    public Response build() {
        return new Response(httpStatus, message, error, body);
    }
}