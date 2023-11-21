package com.project.enjoytrip.exception.global;

import javax.persistence.EntityNotFoundException;

import com.project.enjoytrip.exception.ExceptionCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotFoundException extends EntityNotFoundException {

    private final ExceptionCode exceptionCode;
}
