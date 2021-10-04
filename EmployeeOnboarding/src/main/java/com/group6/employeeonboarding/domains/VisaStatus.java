package com.group6.employeeonboarding.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VisaStatus")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VisaStatus implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "visaType")
    private String visaType;

    @Column(name = "active")
    private String active;

    @Column(name = "modificationDate")
    private String modificationDate;

    @Column(name = "visaStartDate")
    private String visaStartDate;

    @Column(name = "visaEndDate")
    private String visaEndDate;
}