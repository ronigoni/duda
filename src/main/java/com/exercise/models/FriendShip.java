package com.exercise.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@Builder
@Entity
@Table(name = "FRIENDSHIPS")
@IdClass(FriendShipId.class)
@AllArgsConstructor
@NoArgsConstructor
public class FriendShip{
	@Id
	private Long firstPupilId;
	@Id
	private Long secondPupilId;

}
