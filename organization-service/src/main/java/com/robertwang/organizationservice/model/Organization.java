package com.robertwang.organizationservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Organization Model
 * 
 * 
 *
 */
@Table(name = "organizations")
@Entity
@Getter
@Setter
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String address;

	@Transient
	private List<Site> sites = new ArrayList<>();
	@Transient
	private List<User> users = new ArrayList<>();

}
