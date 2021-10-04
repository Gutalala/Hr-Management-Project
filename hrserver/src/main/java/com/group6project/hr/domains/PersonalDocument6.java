package com.group6project.hr.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PersonalDocument")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalDocument6 implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private int id;

   @Column(name = "employee_id")
    private int employee_id;
    
 @Column(name = "path")
    private String path;
    
  @Column(name = "title")
    private String title;
    
   @Column(name = "comment")
    private String comment;
    
  @Column(name = "createdDate")
    private String createdDate;
    
    private String filename;
    

	
}
