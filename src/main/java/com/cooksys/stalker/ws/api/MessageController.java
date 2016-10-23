package com.cooksys.stalker.ws.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.stalker.ws.message.MessageService;
import com.cooksys.stalker.ws.message.entity.Message;
import com.cooksys.stalker.ws.message.entity.model.MessageModel;

@RestController
@RequestMapping("message")
@CrossOrigin(origins = "*")
public class MessageController {
	
	private final MessageService service;
	
	@Autowired
	public MessageController(MessageService service){
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<MessageModel> index(){
		return this.service.index();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public MessageModel create(@PathVariable Long id, @RequestBody Message message){
		return this.service.create(id, message);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Set<MessageModel> indexUser(@PathVariable Long id){
		return this.service.indexUser(id);
	}
}
