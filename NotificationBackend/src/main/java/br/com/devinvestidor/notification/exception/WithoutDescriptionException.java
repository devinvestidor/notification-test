package br.com.devinvestidor.notification.exception;

public class WithoutDescriptionException extends ServiceException {
    public WithoutDescriptionException() {
        super("Provide a description");
    }
}