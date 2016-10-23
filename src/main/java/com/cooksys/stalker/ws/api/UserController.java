package com.cooksys.stalker.ws.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.stalker.ws.message.entity.Message;
import com.cooksys.stalker.ws.user.UserService;
import com.cooksys.stalker.ws.user.entity.User;
import com.cooksys.stalker.ws.user.entity.model.UserBase;
import com.cooksys.stalker.ws.user.entity.model.UserModel;
import com.cooksys.stalker.ws.user.entity.model.UserValidateModel;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
	
	private final UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<UserModel> index(){
		return this.service.index();
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserBase create(@RequestBody User user){
		return this.service.create(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserModel read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public UserValidateModel read(@RequestParam("name") String username){
		return this.service.read(username);
	}
	
	@RequestMapping(value = "/{id}/followers", method = RequestMethod.GET)
	public Set<UserBase> indexFollowers(@PathVariable Long id){
		return this.service.indexFollowers(id);
	}
	
	@RequestMapping(value = "/{id}/following", method = RequestMethod.GET)
	public Set<UserBase> indexFollowing(@PathVariable Long id){
		return this.service.indexFollowing(id);
	}
	
	@RequestMapping(value = "/{id}/messages", method = RequestMethod.GET)
	public Set<Message> indexMessages(@PathVariable Long id){
		return this.service.indexMessages(id);
	}
	
	@RequestMapping(value = "/{id}/follow/{fid}", method = RequestMethod.PUT)
	public UserModel update(@PathVariable Long id, @PathVariable Long fid){
		return this.service.update(id, fid);
	}
}
