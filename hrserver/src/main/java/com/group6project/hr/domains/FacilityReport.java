package com.group6project.hr.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FacilityReport")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FacilityReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "reportDate")
    private String reportDate;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;
}
