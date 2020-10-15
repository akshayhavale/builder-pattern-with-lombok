package com.java.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class StudentResponseDto {

	private int id;
	private String name;
	private boolean active;

}
