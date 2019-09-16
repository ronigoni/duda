package com.exercise.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SCHOOLS")
@Data
public class School {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)    
	private Long id;
	private double lat;
	private double lon;
	private int minimumGpa;
	private int maxNumberOfPupils;
}
