package com.robertwang.organizationservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * User Entity
 * 
 *
 */
@Getter
@Setter
public class User {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String position;


}
