package com.group6project.hr.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.group6project.hr.domains.RegistrationToken;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenResponse {
    private ResponseStatus responseStatus;
    private RegistrationToken registrationToken;
}
