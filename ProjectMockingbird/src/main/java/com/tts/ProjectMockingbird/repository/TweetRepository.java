package com.tts.ProjectMockingbird.repository;

import java.util.List;



import com.tts.ProjectMockingbird.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ProjectMockingbird.model.Tweet;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long>{
	
	
	public List<Tweet> findAllByOrderByCreatedAtDesc(); 
    public List<Tweet> findAllByUserOrderByCreatedAtDesc(User user);
    public List<Tweet> findAllByUserInOrderByCreatedAtDesc(List<User> users);
    public List<Tweet> findByTags_PhraseOrderByCreatedAtDesc(String phrase);

}
