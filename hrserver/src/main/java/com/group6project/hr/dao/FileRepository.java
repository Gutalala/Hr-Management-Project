package com.group6project.hr.dao;

import org.springframework.data.repository.CrudRepository;

import com.group6project.hr.domains.PersonalDocument6;

public interface FileRepository   {
	PersonalDocument6 findByTitle(String title);
}