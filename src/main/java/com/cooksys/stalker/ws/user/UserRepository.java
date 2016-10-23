package com.cooksys.stalker.ws.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.stalker.ws.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
	User findById(Long id);
}
