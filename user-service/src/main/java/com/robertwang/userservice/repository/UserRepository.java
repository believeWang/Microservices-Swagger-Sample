package com.robertwang.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robertwang.userservice.model.User;

/**
 * User Repository
 * 
 * 
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findBySiteId(Long siteId);

	List<User> findByOrganizationId(Long organizationId);
}
