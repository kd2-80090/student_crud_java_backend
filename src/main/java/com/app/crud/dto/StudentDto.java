package com.app.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
	
	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
    
    private String name;
    
    private int age;
    
    private String course;
    
    private String email;
    
}
