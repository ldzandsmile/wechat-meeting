package com.ldz.mapper;

import java.util.List;

import com.ldz.model.MeetingRoom;

public interface MeetingRoomMapper {
	List<MeetingRoom> selectMeetingRoomList();
	
	
    int deleteByPrimaryKey(Long id);

    int insert(MeetingRoom record);

    int insertSelective(MeetingRoom record);

    MeetingRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MeetingRoom record);

    int updateByPrimaryKey(MeetingRoom record);
}