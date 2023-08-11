package com.routinergram.interests.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interests {

	private int ITRID;
	private String interestName;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}
