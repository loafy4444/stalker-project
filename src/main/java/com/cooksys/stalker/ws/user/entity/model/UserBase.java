package com.cooksys.stalker.ws.user.entity.model;

import java.util.HashSet;
import java.util.Set;

import com.cooksys.stalker.ws.user.entity.User;

public class UserBase {

	private Long id;
	
	private String username;
	
	public UserBase(User user){
		this.id = user.getId();
		this.username = user.getUsername();
	}
	
	public static UserBase baseResponse(User user){
		return new UserBase(user);
	}

	public static Set<UserBase> baseList(Set<User> set){
		Set<UserBase> result = new HashSet<>();
		for(User user: set){
			result.add(new UserBase(user));
		}
		return result;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
