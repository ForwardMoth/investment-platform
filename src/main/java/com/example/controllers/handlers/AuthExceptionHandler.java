package com.example.controllers.handlers;


import com.example.exceptions.AuthException;
import com.example.exceptions.messages.AuthErrorMessage;
import com.example.exceptions.messages.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.security.core.AuthenticationException;

@Slf4j
@RestControllerAdvice
public class AuthExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<AuthErrorMessage> handleAuthException(AuthException e) {
        AuthException.CODE code = e.getCode();
        HttpStatus status = switch (code) {
            case NO_SUCH_USERNAME_OR_PWD -> HttpStatus.NOT_FOUND;
            case JWT_VALIDATION_ERROR -> HttpStatus.UNAUTHORIZED;
            case INVALID_REPEAT_PASSWORD -> HttpStatus.BAD_REQUEST;
            case EMAIL_IN_USE -> HttpStatus.CONFLICT;
        };
        String codeStr = code.toString();
        return ResponseEntity
                .status(status)
                .body(new AuthErrorMessage(codeStr, e.getMessage()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorMessage> handleAuthException(AuthenticationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<ErrorMessage> handleAuthException(HttpClientErrorException.Unauthorized e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorMessage(HttpStatus.UNAUTHORIZED.name(), e.getMessage()));
    }
}



