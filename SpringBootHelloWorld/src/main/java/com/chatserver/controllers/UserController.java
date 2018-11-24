package com.chatserver.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chatserver.entity.User;
import com.chatserver.nativequery.UserUtility;
import com.chatserver.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/welcome.html")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/auth.html")
	public ModelAndView authenticate(@RequestParam("email") String email, @RequestParam("pass") String pass,
			HttpServletRequest req) {

		List<User> userList = null;
		System.out.println("email" + email + " pass" + pass);

		if (userService.authenticate(email.trim(), pass.trim())) {

			HttpSession session = req.getSession();
			session.setAttribute("email", email.trim());
			session.setAttribute("id", userService.findByEmailId(email.trim()).getId());

			try {
				userList = UserUtility.getAllUserExcept(email.trim());
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("LoggedInUserEmailId", email);
  			model.put("users", userList);


			return new ModelAndView("chatoption",model);
		} else {
			return new ModelAndView("index", "message",
					"Entered Credentials are not Valid. Please check and try again !!");
		}
	}

	@RequestMapping("/chat.html")
	public ModelAndView chat(@RequestParam("id") String id, HttpServletRequest req ) {
		List<User> userList = null;
		Integer id1 = Integer.parseInt(id); //  selected persion id1 to whome want to do chat 
		User user = userService.findById(id1);
		
		HttpSession session=req.getSession();
		Integer  idd =(Integer)session.getAttribute("id");
		             

		 User user1=userService.findById(idd);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("chatId", id1);
		model.put("LoggedInUserEmailId", user1.getEmailId());

		try {
			userList = UserUtility.getAllUserExcept(user1.getEmailId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.put("users", userList);

		System.out.println("Redirecting to chatoption ");

		return new ModelAndView("chatoption", model);
	}

	// submitChat.html?chatmessage=Hi+Hari&selectedChatId=2

	
	@RequestMapping("/submitChat.html")
	public ModelAndView submitChat(@RequestParam String chatmessage, String selectedChatId, HttpServletRequest req) {
		Integer selectedChatId1=Integer.parseInt(selectedChatId);
		HttpSession session=req.getSession();
		Integer LoggedInUserId=(Integer)session.getAttribute("id");
		
		
		userService.saveChat(LoggedInUserId,selectedChatId1,chatmessage);
		  
		
		return new ModelAndView("index");
	}
	
	 

}
