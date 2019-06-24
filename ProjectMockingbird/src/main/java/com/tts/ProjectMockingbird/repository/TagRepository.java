package com.tts.ProjectMockingbird.repository;



import org.springframework.data.repository.CrudRepository;

import com.tts.ProjectMockingbird.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>{

    Tag findByPhrase(String phrase);

}

