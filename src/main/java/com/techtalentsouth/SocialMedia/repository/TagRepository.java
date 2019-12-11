package com.techtalentsouth.SocialMedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techtalentsouth.SocialMedia.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findByPhrase(String phrase);

}
