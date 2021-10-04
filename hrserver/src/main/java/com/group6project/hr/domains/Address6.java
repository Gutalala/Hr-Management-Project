package com.group6project.hr.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1)
    private int id;

    @Column(name = "employee_id")
    @ApiModelProperty(position = 2)
    private int employee_id;

    @Column(name = "addressLine1")
    @ApiModelProperty(position = 3)
    private String addressLine1;

    @Column(name = "addressLine2")
    @ApiModelProperty(position = 4)
    private String addressLine2;

    @Column(name = "city")
    @ApiModelProperty(position = 5)
    private String city;

    @Column(name = "zipCode")
    @ApiModelProperty(position = 6)
    private String zipCode;

    @Column(name = "stateName")
    @ApiModelProperty(position = 7)
    private String stateName;

    @Column(name = "stateAbbr")
    @ApiModelProperty(position = 8)
    private String stateAbbr;
}