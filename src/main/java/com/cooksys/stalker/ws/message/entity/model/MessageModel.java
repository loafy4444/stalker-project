package com.cooksys.stalker.ws.message.entity.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cooksys.stalker.ws.message.entity.Message;
import com.cooksys.stalker.ws.user.entity.model.UserBase;

public class MessageModel {

	private Long id;
	private UserBase user;
	private Date createdAt;
	private String content;
	
	public MessageModel(Message message){
		this.id = message.getId();
		this.user = UserBase.baseResponse(message.getUser());
		this.createdAt = message.getCreatedAt();
		this.content = message.getContent();
	}
	
	public static MessageModel response(Message message){
		return new MessageModel(message);
	}
	
	public static Set<MessageModel> list(Collection<Message> messages){
		Set<MessageModel> result = new HashSet<>();
		for (Message message : messages) {
			result.add(new MessageModel(message));
		}
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserBase getUser() {
		return user;
	}

	public void setUser(UserBase user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
