package com.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.models.School;
import com.exercise.repository.SchoolRepository;

@Service
public class SchoolServiceImpl implements ISchoolService{

	private SchoolRepository schoolRepository;
	
	@Autowired
	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}

	@Override
	public Long createSchool(School school) {
		School response = schoolRepository.save(school);
		return response.getId();
	}
	
	public List<School> getAllSchools() {
		List<School> Schools = schoolRepository.findAll();
		return Schools;
	}
	

}
