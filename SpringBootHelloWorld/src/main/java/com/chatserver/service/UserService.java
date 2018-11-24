package com.chatserver.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatserver.entity.Conversation;
import com.chatserver.entity.User;
import com.chatserver.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EntityManager entityManager;
	
	

	public boolean authenticate(String email, String pass) {

		User user = userRepository.findByEmailIdAndPass(email, pass);

		System.out.println("User Usert " + user);

		if (user != null) {
			return true;
		}

		return false;
	}

	public User findByEmailId(String emailid) {
		User user = userRepository.findByEmailId(emailid);
		return user;

	}
	public User findById(Integer id) {
		User user = userRepository.findById(id);
		return user;

	}

	@Transactional
	public void saveChat(Integer loggedInUserId, Integer selectedChatId, String chatmessage) {
		Conversation conversation=new Conversation();
		conversation.setChastMessage(chatmessage);
		conversation.setLoggedInUserId(loggedInUserId);
		conversation.setSelectedChatId(selectedChatId);
		entityManager.persist(conversation);
	}
	
	
	
	public void    testRepo(){
		   
// User user=		userRepository.findByEmailIdAndPass("t","t");
		   
	   }
	
	
	
	

}
