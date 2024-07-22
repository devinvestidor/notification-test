package br.com.devinvestidor.notification.exception;

public class WithoutCategoryException extends ServiceException {
    public WithoutCategoryException() {
        super("Select a category");
    }
}