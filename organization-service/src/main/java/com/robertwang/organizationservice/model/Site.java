package com.robertwang.organizationservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Site Entity
 * 

 *
 */
@Getter
@Setter
public class Site {
	

	private Long id;
	
	private String name;
	
	private List<User> users = new ArrayList<>();

}
