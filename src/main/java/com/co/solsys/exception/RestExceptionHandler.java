package com.co.solsys.exception;

import com.co.solsys.model.ErrorMessage;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String BASIC_FORMAT = "%s %s";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return buildResponseEntity(new ErrorMessage(HttpStatus.BAD_REQUEST, "", "Validation failed:" + getFieldErrorMessages(ex)));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleInternalError(Exception ex) {
        return buildResponseEntity(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "", ex.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorMessage errorMessage) {
        return new ResponseEntity<>(errorMessage, errorMessage.getStatus());
    }

    private String getFieldErrorMessages(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(this::buildFieldErrorMessage)
                .collect(Collectors.joining(", "));
    }

    private String buildFieldErrorMessage(ObjectError error) {
        if (error instanceof FieldError) {
            return String.format(BASIC_FORMAT, ((FieldError) error).getField(), error.getDefaultMessage());
        }
        return error.getDefaultMessage();
    }
}
