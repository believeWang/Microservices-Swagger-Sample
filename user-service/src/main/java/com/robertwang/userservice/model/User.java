package com.robertwang.userservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User Model
 * 
 * 
 *
 */
@Table(name = "users")
@Entity
@Getter
@Setter
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "organization_id")
	private Long organizationId;

	@Column(name = "site_id")
	private Long siteId;

	private String name;
	private String email;
	private String phone;
	private String position;


}
