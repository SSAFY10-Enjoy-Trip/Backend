package com.project.enjoytrip.exception.post;

import com.project.enjoytrip.exception.EntityException;
import com.project.enjoytrip.exception.ExceptionCode;

public class PostException extends EntityException {

    public PostException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}