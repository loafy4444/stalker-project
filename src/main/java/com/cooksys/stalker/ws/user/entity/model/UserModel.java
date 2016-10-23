package com.cooksys.stalker.ws.user.entity.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cooksys.stalker.ws.message.entity.model.MessageModel;
import com.cooksys.stalker.ws.user.entity.User;

public class UserModel {

	private Long id;
	private String username;
	private String email;
	private Set<UserBase> followers;
	private Set<UserBase> following;
	private Set<MessageModel> messages;
	
	public UserModel(User user){
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.followers = UserBase.baseList(user.getFollowers());
		this.following = UserBase.baseList(user.getFollowing());
		this.messages = MessageModel.list(user.getMessages());
	}
	
	public static UserModel response(User user){
		return new UserModel(user);
	}
	
	public static Set<UserModel> list(List<User> users){
		Set<UserModel> result = new HashSet<>();
		for (User user : users) {
			result.add(new UserModel(user));
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserBase> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<UserBase> followers) {
		this.followers = followers;
	}

	public Set<UserBase> getFollowing() {
		return following;
	}

	public void setFollowing(Set<UserBase> following) {
		this.following = following;
	}

	public Set<MessageModel> getMessages() {
		return messages;
	}

	public void setMessages(Set<MessageModel> messages) {
		this.messages = messages;
	}
}
