package com.exercise.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "PUPILSCHOOL")
@Data
@Builder
public class PupilSchool {

	@Id
	private Long schoolId;
	private Long pupilId;

	
}
