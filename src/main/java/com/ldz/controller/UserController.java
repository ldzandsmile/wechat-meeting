package com.ldz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldz.model.User;
import com.ldz.service.MeetingRoomService;
import com.ldz.service.UserService;
import com.ldz.utils.MessageUtils;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="selectUserByName", method=RequestMethod.GET)
	public MessageUtils selectUserByName(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("is_admin", userService.selectUserByName(user));
		MessageUtils message = MessageUtils.success(); 
		message.setExtend(map);
		
		return message;
	}
	
	@ResponseBody
	@RequestMapping(value="insertUser", method=RequestMethod.GET)
	public String insertUser(User user){
		userService.insertSelective(user);
		
		return "success";
	}
}
