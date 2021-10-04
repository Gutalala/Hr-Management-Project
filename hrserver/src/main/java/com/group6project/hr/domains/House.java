package com.group6project.hr.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Facility facility;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference(value="house_contact")
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "numberOfPerson")
    private int numberOfPerson;
}