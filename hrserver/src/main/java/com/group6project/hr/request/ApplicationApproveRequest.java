package com.group6project.hr.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApplicationApproveRequest {
	
		private Integer employeeid;
	    private String comments;

}
