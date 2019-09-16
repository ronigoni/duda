package com.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.models.School;
@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
