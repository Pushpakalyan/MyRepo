package com.database.dbex.dto;

import lombok.Data;

@Data
public class PresonRequest {
    private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String dob;
}
