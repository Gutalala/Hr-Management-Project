package com.group6project.hr.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Role")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "description")
    private String description;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "lastModificationDate")
    private String lastModificationDate;

    @Column(name = "lastModificationUserId")
    private String lastModificationUserId;
}
