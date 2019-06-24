package com.tts.ProjectMockingbird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.tts.ProjectMockingbird.model.Role;
import com.tts.ProjectMockingbird.model.User;
import com.tts.ProjectMockingbird.repository.UserRepository;
import com.tts.ProjectMockingbird.repository.RoleRepository;

@Service
public class UserService {
	
	//added @Autowired ubove each method 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository =roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public User findByUsername(String name) {
		return userRepository.findByUsername (name);
	}
	
	public List<User> findAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public void save (User user) {
		userRepository.save(user);
	}
	
	public User saveNewUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}
	
	public User getLoggedInUser() {
		String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		
	return findByUsername(loggedInUsername);
	}
	

}
