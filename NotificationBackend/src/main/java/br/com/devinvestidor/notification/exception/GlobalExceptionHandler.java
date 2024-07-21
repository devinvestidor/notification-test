package br.com.devinvestidor.notification.exception;

import br.com.devinvestidor.notification.response.HttpResponse;
import br.com.devinvestidor.notification.response.Response;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            BadRequestException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class
    })
    public ResponseEntity<Response> handleBadRequestExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(HttpResponse.error(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Response> handleNoContentException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(HttpResponse.noContent(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Response> handleServiceException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(HttpResponse.warning(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(HttpResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}