package com.cooksys.stalker.ws.message;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.stalker.ws.message.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

	Set<Message> findByUserId(Long id);
}
