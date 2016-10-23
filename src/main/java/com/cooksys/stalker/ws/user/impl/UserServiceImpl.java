package com.cooksys.stalker.ws.user.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.stalker.ws.message.entity.Message;
import com.cooksys.stalker.ws.user.UserRepository;
import com.cooksys.stalker.ws.user.UserService;
import com.cooksys.stalker.ws.user.entity.User;
import com.cooksys.stalker.ws.user.entity.model.UserBase;
import com.cooksys.stalker.ws.user.entity.model.UserModel;
import com.cooksys.stalker.ws.user.entity.model.UserValidateModel;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repo;
	
	@Autowired
	public UserServiceImpl(UserRepository repo){
		this.repo = repo;
	}

	@Override
	public Set<UserModel> index() {
		return UserModel.list(this.repo.findAll());
	}

	@Override
	public UserBase create(User user) {
		this.repo.save(user);
		return UserBase.baseResponse(this.repo.findByUsername(user.getUsername()));
	}
	
	@Override
	public UserModel read(Long id) {
		return UserModel.response(this.repo.findById(id));
	}

	@Override
	public UserValidateModel read(String username) {
		return UserValidateModel.validResponse(this.repo.findByUsername(username));
	}

	@Override
	public Set<UserBase> indexFollowers(Long id) {
		return UserBase.baseList(this.repo.findById(id).getFollowers());
	}

	@Override
	public Set<UserBase> indexFollowing(Long id) {
		return UserBase.baseList(this.repo.findById(id).getFollowing());
	}

	@Override
	public Set<Message> indexMessages(Long id) {
		return this.repo.findById(id).getMessages();
	}

	@Override
	public UserModel update(Long id, Long fid) {
		this.repo.findById(id).getFollowing().add(this.repo.findById(fid));
		return UserModel.response(this.repo.findById(id));
	}
	
	
}
