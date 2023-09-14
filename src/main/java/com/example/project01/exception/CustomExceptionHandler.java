package com.example.project01.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.http.HttpClient;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> EmailValidException() {
        return ResponseEntity.status(303).build();
    }
}