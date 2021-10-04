package com.group6project.hr.domains;

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
public class VisaStatus6 implements Serializable {
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    
    
    @Column(name = "employee_id")
    private int employee_id;

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