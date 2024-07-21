package br.com.devinvestidor.notification.exception;

public class WithoutEmailException extends ServiceException {
    public WithoutEmailException() {
        super("Don't have email.");
    }
}