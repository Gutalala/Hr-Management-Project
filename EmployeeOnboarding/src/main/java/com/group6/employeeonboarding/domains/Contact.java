package com.group6.employeeonboarding.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Contact")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Serializable {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "email")
    private String email;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "title")
    private String title;

    @Column(name = "isReference")
    private boolean reference;

    @Column(name = "isEmergency")
    private boolean emergency;

    @Column(name = "isLandlord")
    private boolean landlord;
}