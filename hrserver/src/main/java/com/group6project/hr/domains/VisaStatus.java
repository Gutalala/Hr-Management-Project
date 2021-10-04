package com.group6project.hr.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VisaStatus")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class VisaStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value="employee_visastatus")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ApiModelProperty(notes = "Visa Type of Each Employee")
    @Column(name = "visaType")
    private String visaType;

    @ApiModelProperty(notes = "Visa Expiration Check")
    @Column(name = "active")
    private String active;

    @Column(name = "modificationDate")
    private String modificationDate;

    @Column(name = "visaStartDate")
    private String visaStartDate;

    @Column(name = "visaEndDate")
    private String visaEndDate;
}