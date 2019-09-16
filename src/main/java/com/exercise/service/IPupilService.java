package com.exercise.service;

import com.exercise.models.Pupil;

public interface IPupilService {
	
	Long createPupil(Pupil pupil);
	
	void setFriendShip(Long firstPupilId,Long secondPupilId);

	void enrollPupil(Long pupilId);
}
