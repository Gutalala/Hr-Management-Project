package com.group6project.hr.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Facility")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Facility implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "house_id")
    private House house;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "numOfBed")
    private int numOfBed;

    @Column(name = "numOfMattress")
    private int numOfMattress;

    @Column(name = "numOfTable")
    private int numOfTable;

    @Column(name = "numOfChair")
    private int numOfChair;
}
