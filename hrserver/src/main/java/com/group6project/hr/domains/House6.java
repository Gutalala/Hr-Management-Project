package com.group6project.hr.domains;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "House")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class House6 {

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