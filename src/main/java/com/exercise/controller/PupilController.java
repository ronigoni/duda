package com.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exercise.models.FriendShip;
import com.exercise.models.Pupil;
import com.exercise.service.IPupilService;

@Controller
public class PupilController {

	private IPupilService service;
	
	@Autowired
	public PupilController(IPupilService service) {
		this.service = service;
	}

	public Long createPupil(Pupil pupil) {
		return service.createPupil(pupil);
	}
	
	public void setFriendShip(Long firstPupilId, Long secondPupilId) {
		service.setFriendShip(firstPupilId, secondPupilId);
	}

	public void enrollPupil(Long pupilId) {
		service.enrollPupil(pupilId);
	}

}
