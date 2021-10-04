package com.group6project.hr.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserRole")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "activeFlag")
    private boolean activeFlag;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "lastModificationDate")
    private String lastModificationDate;

    @Column(name = "lastModificationUser")
    private String lastModificationUser;
}
