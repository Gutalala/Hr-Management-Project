package com.group6project.hr.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group6project.hr.domains.House;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HouseResponse {
    private ResponseStatus responseStatus;
    private House house;
}