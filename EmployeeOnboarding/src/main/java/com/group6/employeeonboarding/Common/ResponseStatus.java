package com.group6.employeeonboarding.Common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseStatus {
    private boolean success;
    private String message;
}