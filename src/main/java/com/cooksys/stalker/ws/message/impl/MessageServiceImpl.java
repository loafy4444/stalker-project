package com.cooksys.stalker.ws.message.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.stalker.ws.message.MessageRepository;
import com.cooksys.stalker.ws.message.MessageService;
import com.cooksys.stalker.ws.message.entity.Message;
import com.cooksys.stalker.ws.message.entity.model.MessageModel;
import com.cooksys.stalker.ws.user.UserRepository;

@Service
public class MessageServiceImpl implements MessageService{

	private final MessageRepository repo;
	private final UserRepository userRepo;
	
	@Autowired
	public MessageServiceImpl(MessageRepository repo, UserRepository userRepo){
		this.repo = repo;
		this.userRepo = userRepo;
	}

	@Override
	public Set<MessageModel> index() {
		return MessageModel.list(this.repo.findAll());
	}

	@Override
	public MessageModel create(Long id, Message message) {
		Message temp = message;
		temp.setUser(this.userRepo.findById(id));
		this.repo.save(temp);
		return MessageModel.response(temp);
	}

	@Override
	public Set<MessageModel> indexUser(Long id) {
		return MessageModel.list(this.userRepo.findById(id).getMessages());
	}
	
	
}
