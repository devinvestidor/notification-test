package br.com.devinvestidor.notification.exception;

public class ServiceException extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}