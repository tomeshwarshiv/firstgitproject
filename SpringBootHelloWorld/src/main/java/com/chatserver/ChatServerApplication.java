package com.chatserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.chatserver.entity.User;
import com.chatserver.service.UserService;

@SpringBootApplication
public class ChatServerApplication { 

	public static void main(String[] args) {
	ApplicationContext ctx=	SpringApplication.run(ChatServerApplication.class, args);
	UserService userService=(UserService)ctx.getBean("userService");
	boolean  u=userService.authenticate("tomesh@gmail.com","t");
	  System.out.println(u);
	  
	  userService.testRepo();
	
	}
}
