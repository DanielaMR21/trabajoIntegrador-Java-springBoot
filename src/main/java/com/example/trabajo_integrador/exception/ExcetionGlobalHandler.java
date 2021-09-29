package com.example.trabajo_integrador.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.apache.log4j.Logger;

@ControllerAdvice
public class ExcetionGlobalHandler {

    private static final Logger logger = Logger.getLogger(ExcetionGlobalHandler.class);

    @ExceptionHandler(CustomBaseException.class)
    public ResponseEntity<CustomBaseException> validationErrors(CustomBaseException exception) {
        logger.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }
}
