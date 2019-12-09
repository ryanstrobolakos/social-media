package com.techtalentsouth.SocialMedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.techtalentsouth.SocialMedia.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);

}
