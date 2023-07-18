package com.robertwang.organizationservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.robertwang.organizationservice.client.UserClient;
import com.robertwang.organizationservice.model.Organization;
import com.robertwang.organizationservice.service.OrganizationService;

/**
 * Organizations Controller
 * 
 * 
 *
 */
@RestController
@RequestMapping("organizations/api/v1")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;


	@Autowired
	private UserClient userClient;

	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		return organizationService.save(organization);
	}

	@GetMapping
	public List<Organization> findAll() {
		return organizationService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Organization> organization = organizationService.get(id);
		if (organization.isPresent())
			return new ResponseEntity<>(organization.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>("Organization not found with id: " + id, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/with-users")
	public Organization findByIdWithUsers(@PathVariable("id") Long id) {
		Optional<Organization> organizationOpt = organizationService.get(id);
		Organization organization = null;
		if (organizationOpt.isPresent()) {
			organization = organizationOpt.get();
			organization.setUsers(userClient.findByOganizationId(organization.getId()));
		}
		return organization;
	}
}
