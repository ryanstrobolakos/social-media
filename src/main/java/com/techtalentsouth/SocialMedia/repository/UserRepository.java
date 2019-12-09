package com.techtalentsouth.SocialMedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.techtalentsouth.SocialMedia.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}
