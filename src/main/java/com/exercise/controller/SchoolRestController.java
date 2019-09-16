package com.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.models.School;

@RestController
public class SchoolRestController {

	private SchoolController schoolController;
	
	@Autowired
	public SchoolRestController(SchoolController schoolController) {
		this.schoolController = schoolController;
	}
    @PostMapping(value = "school")
    public Long createSchool(@RequestBody School school) {
    	return schoolController.createSchool(school);
    }


}
