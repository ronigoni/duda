package com.exercise.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.models.FriendShip;
import com.exercise.models.Grade;
import com.exercise.models.Pupil;
import com.exercise.models.PupilSchool;
import com.exercise.models.School;
import com.exercise.repository.FriendShipRepository;
import com.exercise.repository.PupilRepository;
import com.exercise.repository.PupilSchoolRepository;
import com.exercise.repository.SchoolRepository;
import com.exercise.util.HaversineFormulaUtil;

import lombok.Builder;
@Service
public class PupilServiceImpl implements IPupilService {

	private PupilRepository pupilRepo;
	private FriendShipRepository friendShipRepository;
	private SchoolServiceImpl schoolService;
	private PupilSchoolRepository pupilSchoolRepository;
	
	@Autowired
	public PupilServiceImpl(PupilRepository pupilRepo, FriendShipRepository friendShipRepository
			, SchoolServiceImpl schoolService, PupilSchoolRepository pupilSchoolRepository) {
		this.pupilRepo = pupilRepo;
		this.friendShipRepository = friendShipRepository;
		this.schoolService = schoolService;
	}

	@Override
	public Long createPupil(Pupil pupil) {
		Pupil response = pupilRepo.save(pupil);
		return response.getId();
	}

	@Override
	public void setFriendShip(Long firstPupilId, Long secondPupilId) {
		FriendShip friendShip = FriendShip.builder().firstPupilId(firstPupilId).secondPupilId(secondPupilId).build();
		friendShipRepository.save(friendShip);
	}

	@Override
	public void enrollPupil(Long pupilId) {
		
		Optional<Pupil> pupilOpt = pupilRepo.findById(pupilId);
		List<School> schools = schoolService.getAllSchools();
		Pupil pupil = pupilOpt.get();
		List<FriendShip> friends = new ArrayList();
		List<FriendShip> friendsFromDb = friendShipRepository.findAll();
		for(int i = 0 ; i < friends.size(); i++) {
			if(!friends.get(i).getFirstPupilId().equals(pupil.getId()) && !friends.get(i).getSecondPupilId().equals(pupil.getId()))
				friends.add(friends.get(i));
				}
				
		double gpa = calculateGPA(pupil.getGrades());
		Map <Double,School> schoolByDistance = getSchoolByDistance(pupil, schools);
		Map<Long, Integer> schoolByFriends = getSchoolByFriends(pupil,friends);
		
		double max = 0;
		for (Map.Entry<Double, School> entry : schoolByDistance.entrySet()) {
			int numberOfFriends = schoolByFriends.get(entry.getValue().getId());
			if(entry.getKey()/Double.valueOf(numberOfFriends) > max && entry.getValue().getMinimumGpa() <= gpa)
				max = entry.getValue().getId();
		}
		
		PupilSchool pupilSchool = PupilSchool.builder().pupilId(pupil.getId()).schoolId((long)max).build();
		pupilSchoolRepository.save(pupilSchool);		
		
	}

	private Map<Long,Integer> getSchoolByFriends(Pupil pupil, List<FriendShip> friends) {
		Map<Long,Integer> schoolByFriends = new HashMap();
			for(int i = 0 ; i < friends.size(); i++) {
				Optional<PupilSchool> school = pupilSchoolRepository.findById(friends.get(i).getFirstPupilId());
				PupilSchool schoolId = school.get();
				if(schoolByFriends.containsKey(schoolId.getSchoolId())){
						int num = schoolByFriends.get(friends.get(i).getFirstPupilId());
						schoolByFriends.put(schoolId.getSchoolId(), num+1);
				}
				else
					schoolByFriends.put(schoolId.getSchoolId(), 1);
			}
			return schoolByFriends;
	}
	
	private Map<Double, School> getSchoolByDistance(Pupil pupil, List<School> schools) {
		return schools.stream().sorted().collect(Collectors
				.toMap(school -> HaversineFormulaUtil.distance(pupil.getLat(),school.getLat(), pupil.getLon(), school.getLon()), school -> school));
	}

	private double calculateGPA(List<Grade> grades) {
		return grades.stream().mapToDouble(Grade::getGrade).average().orElse(Double.NaN);
	}
	


}
