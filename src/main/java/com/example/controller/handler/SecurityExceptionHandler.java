package com.example.controller.handler;

import com.example.exception.SecurityException;
import com.example.exception.message.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class SecurityExceptionHandler {
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErrorMessage> handleSecurityException(SecurityException e) {
        SecurityException.CODE code = e.getCode();
        HttpStatus status = switch (code) {
            case TICKER_IN_USE -> HttpStatus.CONFLICT;
            case NO_SUCH_SECURITY -> HttpStatus.NOT_FOUND;
        };
        String codeStr = code.toString();
        log.error(e.getMessage());
        return ResponseEntity
                .status(status)
                .body(new ErrorMessage(codeStr, e.getMessage()));
    }
}