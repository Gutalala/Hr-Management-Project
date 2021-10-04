package com.group6project.hr.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Contact")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Contact implements Serializable {

    @ManyToOne
    @JsonBackReference(value="employee_contact")
    @JoinColumn(name = "employee_id")
    @ApiModelProperty(position = 2, notes = "Employee Associated with this Contact")
    private Employee employee;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonBackReference(value="house_contact")
    @ApiModelProperty(position = 3, notes = "House Associated with Contacts who are Landlords")
    private House house;

    @Id
    @ApiModelProperty(position = 1)
    private int id;

    @Column(name = "firstName")
    @ApiModelProperty(position = 4)
    private String firstName;

    @Column(name = "lastName")
    @ApiModelProperty(position = 5)
    private String lastName;

    @Column(name = "cellphone")
    @ApiModelProperty(position = 6)
    private String cellphone;

    @Column(name = "email")
    @ApiModelProperty(position = 7)
    private String email;

    @Column(name = "relationship")
    @ApiModelProperty(position = 8)
    private String relationship;

    @Column(name = "title")
    @ApiModelProperty(position = 9)
    private String title;

    @Column(name = "isReference")
    @ApiModelProperty(position = 10)
    private boolean reference;

    @Column(name = "isEmergency")
    @ApiModelProperty(position = 11)
    private boolean emergency;

    @Column(name = "isLandlord")
    @ApiModelProperty(position = 12)
    private boolean landlord;
}