package com.group6.employeeonboarding.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "House")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "contact_id")
    private int contact_id;

    @Column(name = "address")
    private String address;

    @Column(name = "numberOfPerson")
    private int numberOfPerson;
}