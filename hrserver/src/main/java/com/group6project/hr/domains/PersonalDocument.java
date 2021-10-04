package com.group6project.hr.domains;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "PersonalDocument")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class PersonalDocument implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JsonBackReference(value="employee_personalDocument")
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    @Column(name = "path")
    private String path;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "comment")
    private String comment;
    
    @Column(name = "createdDate")
    private String createdDate;

    @Column(name = "filename")
    private String filename;
	
}
