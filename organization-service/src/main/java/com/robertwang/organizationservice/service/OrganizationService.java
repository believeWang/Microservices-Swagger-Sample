package com.robertwang.organizationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertwang.organizationservice.model.Organization;
import com.robertwang.organizationservice.repository.OrganizationRepository;

/**
 * Organization Service
 * 
 *
 */
@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	public Organization save(Organization organization) {
		return organizationRepository.save(organization);
	}

	public List<Organization> getAll() {
		List<Organization> organizations = organizationRepository.findAll();
		return organizations;
	}

	public Optional<Organization> get(Long id) {
		return organizationRepository.findById(id);
	}

	public void delete(Long id) {
		organizationRepository.deleteById(id);
	}

}
