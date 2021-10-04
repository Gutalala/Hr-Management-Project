package com.group6project.hr.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Address implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "employee_address")
    @JoinColumn(name = "employee_id")
    @ApiModelProperty(position = 2, notes = "Employee Associated with Address")
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1)
    private int id;

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
    @ApiModelProperty(position = 8, notes = "State Name Abbreviation")
    private String stateAbbr;
}