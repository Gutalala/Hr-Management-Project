package com.group6project.hr.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Contact")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Contact6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1)
    private int id;

    @Column(name = "firstName")
    @ApiModelProperty(position = 2)
    private String firstName;

    @Column(name = "lastName")
    @ApiModelProperty(position = 3)
    private String lastName;

    @Column(name = "cellphone")
    @ApiModelProperty(position = 4)
    private String cellphone;

    @Column(name = "email")
    @ApiModelProperty(position = 5)
    private String email;

    @Column(name = "employee_id")
    @ApiModelProperty(position = 6)
    private int employee_id;

    @Column(name = "relationship")
    @ApiModelProperty(position = 7)
    private String relationship;

    @Column(name = "title")
    @ApiModelProperty(position = 8)
    private String title;

    @Column(name = "isReference")
    @ApiModelProperty(position = 9)
    private boolean isReference;

    @Column(name = "isEmergency")
    @ApiModelProperty(position = 10)
    private boolean isEmergency;

    @Column(name = "isLandlord")
    @ApiModelProperty(position = 11)
    private boolean isLandlord;
}