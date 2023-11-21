package com.project.enjoytrip.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.enjoytrip.exception.account.AccountException;
import com.project.enjoytrip.exception.follow.FollowException;
import com.project.enjoytrip.exception.global.NotFoundException;
import com.project.enjoytrip.exception.post.PostException;
import com.project.enjoytrip.exception.response.ExceptionResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFound(NotFoundException e) {
        return handleExceptionInternal(e.getExceptionCode());
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<?> handleIntegrityViolation() {
        return handleExceptionInternal(ExceptionCode.DATA_INTEGRITY_VIOLATION);
    }

    @ExceptionHandler({AccountException.class, FollowException.class, PostException.class})
    public ResponseEntity<?> handleEntity(EntityException e) {
        return handleExceptionInternal(e.getExceptionCode());
    }

    private ResponseEntity<Object> handleExceptionInternal(ExceptionCode exceptionCode) {
        return ResponseEntity.status(exceptionCode.getHttpStatus())
                .body(createExceptionResponse(exceptionCode));
    }

    private ExceptionResponse createExceptionResponse(ExceptionCode exceptionCode) {
        return ExceptionResponse.builder()
                .code(exceptionCode.name())
                .message(exceptionCode.getMessage())
                .build();
    }
}
