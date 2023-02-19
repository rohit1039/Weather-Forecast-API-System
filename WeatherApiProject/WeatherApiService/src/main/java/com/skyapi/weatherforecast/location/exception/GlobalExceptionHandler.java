package com.skyapi.weatherforecast.location.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        final Map<String, String> errors = new ConcurrentHashMap<>();

        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        exception.getBindingResult().getGlobalErrors().forEach((errorGlobal) -> {
            errors.put(((FieldError) errorGlobal).getField(), errorGlobal.getDefaultMessage());
        });

        LOGGER.error("{}", errors);

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    private ResponseEntity<ExceptionInResponse> handleLocationNotException(LocationNotFoundException ex) {

        ExceptionInResponse exceptionInResponse = new ExceptionInResponse(LocalDateTime.now(),
                                                                          HttpStatusCode.valueOf(404),
                                                                          ex.getLocalizedMessage());

        LOGGER.error(ex.getLocalizedMessage(), ex);

        return new ResponseEntity<>(exceptionInResponse, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ExceptionInResponse> handleGenericException(Exception ex) {

        ExceptionInResponse exceptionInResponse = new ExceptionInResponse(LocalDateTime.now(),
                                                                          HttpStatusCode.valueOf(500),
                                                                          ex.getLocalizedMessage());

        LOGGER.error(ex.getLocalizedMessage(), ex);

        return new ResponseEntity<>(exceptionInResponse, HttpStatusCode.valueOf(500));
    }
}
