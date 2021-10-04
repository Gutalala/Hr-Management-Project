package com.group6project.hr.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FacilityReportDetail")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FacilityReportDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "facilityReport_id")
    private int facilityReport_id;

    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "comments")
    private String comments;

    @Column(name = "createdDate")
    private String createdDate;

    @Column(name = "lastModificationDate")
    private String lastModificationDate;
}
