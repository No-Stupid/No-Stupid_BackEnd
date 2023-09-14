package com.example.project01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.http.HttpClient;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
public class EmailCheckException extends RuntimeException {

    public EmailCheckException(String message) {
        super(message);
    }

    public EmailCheckException(Throwable cause) {
        super(cause);
    }
}