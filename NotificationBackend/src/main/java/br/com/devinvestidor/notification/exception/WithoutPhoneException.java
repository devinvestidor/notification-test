package br.com.devinvestidor.notification.exception;

public class WithoutPhoneException extends ServiceException {
    public WithoutPhoneException() {
        super("Don't have phone");
    }
}