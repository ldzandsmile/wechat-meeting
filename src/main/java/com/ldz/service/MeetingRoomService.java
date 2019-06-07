package com.ldz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldz.mapper.MeetingRoomMapper;
import com.ldz.model.MeetingRoom;

@Service
public class MeetingRoomService {
	@Autowired
	private MeetingRoomMapper meetingRoomMapper;

	public List<MeetingRoom> selectMeetingRoomList() {
		return this.meetingRoomMapper.selectMeetingRoomList();
	}

}