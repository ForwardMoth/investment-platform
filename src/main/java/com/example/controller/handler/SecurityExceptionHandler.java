package com.example.controller.handler;

import com.example.exception.message.SecurityErrorMessage;
import com.example.exception.SecurityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class SecurityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<SecurityErrorMessage> handleSecurityException(SecurityException e) {
        SecurityException.CODE code = e.getCode();
        HttpStatus status = switch (code) {
            case TICKER_IN_USE -> HttpStatus.CONFLICT;
        };
        String codeStr = code.toString();
        return ResponseEntity
                .status(status)
                .body(new SecurityErrorMessage(codeStr, e.getMessage()));
    }
}
