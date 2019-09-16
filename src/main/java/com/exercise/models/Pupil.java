package com.exercise.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PUPILS")
@Data
public class Pupil {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)    
	private Long id;
	private double lat;
	private double lon;
	@ElementCollection
	private List <Grade> grades;

}
