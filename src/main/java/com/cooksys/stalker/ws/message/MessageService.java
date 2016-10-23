package com.cooksys.stalker.ws.message;

import java.util.Set;

import com.cooksys.stalker.ws.message.entity.Message;
import com.cooksys.stalker.ws.message.entity.model.MessageModel;

public interface MessageService {

	Set<MessageModel> index();

	MessageModel create(Long id, Message message);

	Set<MessageModel> indexUser(Long id);

}
