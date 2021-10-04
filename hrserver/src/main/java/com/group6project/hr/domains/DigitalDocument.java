package com.group6project.hr.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DigitalDocument")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DigitalDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1)
    private int id;

    @Column(name = "type")
    @ApiModelProperty(position = 2)
    private String type;

    @Column(name = "required")
    @ApiModelProperty(position = 3, required = true)
    private boolean required;

    @Column(name = "templateLocation")
    @ApiModelProperty(position = 4)
    private String templateLocation;

    @Column(name = "description")
    @ApiModelProperty(position = 5)
    private String description;

    @Column(name = "title")
    @ApiModelProperty(position = 6)
    private String title;
}
