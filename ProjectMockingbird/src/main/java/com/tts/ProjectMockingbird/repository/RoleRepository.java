package com.tts.ProjectMockingbird.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ProjectMockingbird.model.Role;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole (String Role);

}
