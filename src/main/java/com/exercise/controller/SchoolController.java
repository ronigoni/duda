package com.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exercise.models.School;
import com.exercise.service.ISchoolService;

@Controller
public class SchoolController {

	private ISchoolService schoolService;
	
	@Autowired
	public SchoolController(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	public Long createSchool(School school) {
		return schoolService.createSchool(school);
	}



	
}
