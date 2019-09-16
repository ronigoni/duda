package com.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.models.Pupil;
@Repository
public interface PupilRepository extends JpaRepository<Pupil, Long>{

}
