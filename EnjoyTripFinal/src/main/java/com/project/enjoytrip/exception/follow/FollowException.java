package com.project.enjoytrip.exception.follow;

import com.project.enjoytrip.exception.EntityException;
import com.project.enjoytrip.exception.ExceptionCode;

public class FollowException extends EntityException {

    public FollowException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
