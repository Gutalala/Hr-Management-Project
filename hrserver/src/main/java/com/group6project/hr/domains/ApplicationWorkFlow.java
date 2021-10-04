package com.group6project.hr.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "ApplicationWorkFlow")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationWorkFlow implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1)
    private int id;
    
    @Column(name = "employee_id")
    @ApiModelProperty(position = 2)
    private int employee_id;
    
    @Column(name = "createdDate")
    @ApiModelProperty(position = 3)
    private String createdDate;
    
    @Column(name = "modificationDate")
    @ApiModelProperty(position = 4)
    private String modificationDate;
    
    @Column(name = "status")
    @ApiModelProperty(position = 5, notes = "Open, Pending, Rejected, Completed")
    private String status;
    
    @Column(name = "comments")
    @ApiModelProperty(position = 6)
    private String comments;
    
	
	

}
