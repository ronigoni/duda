package com.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.models.Pupil;

@RestController
public class PupilRestController {
	
	private PupilController pupilController;
	
	@Autowired
	public PupilRestController(PupilController pupilController) {
		this.pupilController = pupilController;
	}
	
    @PostMapping(value = "pupil")
    public Long createPupil(@RequestBody Pupil pupil) {
    	return pupilController.createPupil(pupil);
    }

    @PostMapping(value = "/setFriendShip/{firstPupilId}/{secondPupilId}")
    public void setFriendShip(@PathVariable(value="firstPupilId") Long firstPupilId, 
    		@PathVariable(value="secondPupilId") Long secondPupilId) {
    	 pupilController.setFriendShip(firstPupilId,secondPupilId);
    }
    
    @PostMapping(value = "enroll/{pupilId}")
    public void enrollPupil(@PathVariable(value="pupilId") Long pupilId) {
    	 pupilController.enrollPupil(pupilId);
    }
}
