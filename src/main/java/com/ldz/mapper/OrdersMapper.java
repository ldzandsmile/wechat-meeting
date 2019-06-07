package com.ldz.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldz.model.Orders;

public interface OrdersMapper {
	//查询全部未审核预定消息
	List<Orders> selectOrdersByIsSuccess();
	
	//一个账号只能同时预约一次  查询 username 和 end_time
	List<Orders> selectOrdersByUsernameAndEndTime(@Param("username")String username, @Param("endTime")String endTime);
	
	//查询接下来一周内所有预约消息  
	List<Orders> selectOrdersNextWeek(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("meetingroom")String meetingroom);
	
    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}