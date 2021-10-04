package com.group6project.hr.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {
    TODO_IMAGE("spring-amazon-storage-group6");
    private final String bucketName;
    
}