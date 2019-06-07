package com.ldz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldz.service.MeetingRoomService;
import com.ldz.utils.MessageUtils;

@Controller
public class MeetingRoomController {

	@Autowired
	private MeetingRoomService meetingRoomService;
	
	@ResponseBody
	@RequestMapping(value="selectMeetingRoomList", method=RequestMethod.GET)
	public MessageUtils selectMeetingRoomList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("meetingRoomList", meetingRoomService.selectMeetingRoomList());
		MessageUtils message = MessageUtils.success(); 
		message.setExtend(map);
		
		return message;
	}
}
