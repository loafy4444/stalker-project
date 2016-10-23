package com.cooksys.stalker.ws.user;

import java.util.Set;

import com.cooksys.stalker.ws.message.entity.Message;
import com.cooksys.stalker.ws.user.entity.User;
import com.cooksys.stalker.ws.user.entity.model.UserBase;
import com.cooksys.stalker.ws.user.entity.model.UserModel;
import com.cooksys.stalker.ws.user.entity.model.UserValidateModel;

public interface UserService {

	Set<UserModel> index();

	UserBase create(User user);
	
	UserModel read(Long id);

	UserValidateModel read(String username);

	Set<UserBase> indexFollowers(Long id);

	Set<UserBase> indexFollowing(Long id);

	Set<Message> indexMessages(Long id);

	UserModel update(Long id, Long fid);

}
