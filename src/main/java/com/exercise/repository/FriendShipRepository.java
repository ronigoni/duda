package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.models.FriendShip;

@Repository
public interface FriendShipRepository extends JpaRepository<FriendShip, Long> {
	
}
