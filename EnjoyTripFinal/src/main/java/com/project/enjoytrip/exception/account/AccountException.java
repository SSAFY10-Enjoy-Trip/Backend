package com.project.enjoytrip.exception.account;

import com.project.enjoytrip.exception.EntityException;
import com.project.enjoytrip.exception.ExceptionCode;
public class AccountException extends EntityException {

    public AccountException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}