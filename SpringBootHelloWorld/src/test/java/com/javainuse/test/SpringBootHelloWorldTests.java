package com.javainuse.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chatserver.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHelloWorldTests {

	
	@Autowired 
	UserService userService;
 	
	@Test
	public void add() {
		
		assertEquals(10, 10);
	}

}