package com.chatserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatserver.entity.Conversation;

@Repository
public interface ConversationRepository  extends CrudRepository<Conversation, Integer> {

	
	
	
	

}
