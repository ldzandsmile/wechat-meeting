package com.ldz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldz.mapper.OrdersMapper;
import com.ldz.model.Orders;

@Service
public class OrdersService {
	@Autowired
	private OrdersMapper ordersMapper;

	public void insertSelective(Orders orders) {
		this.ordersMapper.insertSelective(orders);
	}
	
	public void updateByPrimaryKeySelective(Orders orders){
		this.ordersMapper.updateByPrimaryKeySelective(orders);
	}
	
	public Orders selectByPrimaryKey(Orders orders){
		if(orders.getId() != null){
			orders = this.ordersMapper.selectByPrimaryKey(orders.getId());
		} else {
			orders = null;
		}
		
		return orders;
	}
	
	public List<Orders> selectOrdersByIsSuccess(){
		return this.ordersMapper.selectOrdersByIsSuccess();
	}
	
	public List<Orders> selectOrdersByUsernameAndEndTime(Orders orders, String time){
		List<Orders> ordersList = new ArrayList<Orders>();
		if(orders.getEndTime() != null && orders.getUsername() != null){
			ordersList = this.ordersMapper.selectOrdersByUsernameAndEndTime(orders.getUsername(), time);
		}
		
		return ordersList;
	}
	
	public List<Orders> selectOrdersNextWeek(String startTime, String endTime, String meetingroom){
		return this.ordersMapper.selectOrdersNextWeek(startTime, endTime, meetingroom);
	}
}