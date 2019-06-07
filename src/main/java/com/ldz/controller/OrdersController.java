package com.ldz.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldz.model.Orders;
import com.ldz.service.OrdersService;
import com.ldz.utils.DateUtils;
import com.ldz.utils.MessageUtils;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@ResponseBody
	@RequestMapping(value="insertOrders", method=RequestMethod.GET)
	public String insertOrders(HttpServletRequest request, Orders orders){
		//未审核
		orders.setSuccess(false);
		//设置起始时间和结束时间
		String start_time = request.getParameter("start");
		String end_time = request.getParameter("end");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			orders.setStartTime(dateFormat.parse(start_time));
			orders.setEndTime(dateFormat.parse(end_time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ordersService.selectOrdersByUsernameAndEndTime(orders, DateUtils.DateToString(new Date())).size() != 0){
			return  new String("you have ordered");
		}
		
		ordersService.insertSelective(orders);
		
		return "success";
	}
	
	//审核通过
	@ResponseBody
	@RequestMapping(value="examine", method=RequestMethod.GET)
	public String examine(Orders orders){
		orders = ordersService.selectByPrimaryKey(orders);
		
		if(orders == null){
			return "no orders";
		}
		
		orders.setSuccess(true);
		
		ordersService.updateByPrimaryKeySelective(orders);
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="selectOrdersByIsSuccess", method=RequestMethod.GET)
	public MessageUtils selectOrdersByIsSuccess(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("UnauditedList", ordersService.selectOrdersByIsSuccess());
		MessageUtils message = MessageUtils.success(); 
		message.setExtend(map);
		
		//用于查看时间
		//map.put("time",  DateUtils.DateToString(ordersService.selectOrdersByIsSuccess().get(0).getStartTime()));

		return message;
	}
	
	//查看一周内所有预约信息
	@ResponseBody
	@RequestMapping(value="selectOrdersNextWeek", method=RequestMethod.GET)
	public MessageUtils selectOrdersNextWeek(@RequestParam("meetingroom")String meetingroom){
		//获取当前时间的开始时间
		Date startTime = DateUtils.StartTimeOfDay(new Date());
		Date endTime = new Date(startTime.getTime() + 7 * 24 *60 *60 *1000);
		
		//获取接下来一周内所有预约信息
		List<Orders> aWeekList = ordersService.selectOrdersNextWeek(DateUtils.DateToString(startTime), DateUtils.DateToString(endTime), meetingroom);
		
		//创建二维数组 对应一周内8:00-16:00内所有时间段
		Orders[][] orderArray = new Orders[7][24];
		
		for(Orders orders : aWeekList){
			//判断是数组哪个元素被填充
			int x,y;
			//数据库时间 起始
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(orders.getStartTime());
			//数据库时间 结束
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(orders.getEndTime());
			//今天
			Calendar calendar3 = Calendar.getInstance();
			calendar3.setTime(startTime);
			
			x = calendar1.get(Calendar.DATE) - calendar3.get(Calendar.DATE);
			y = calendar1.get(Calendar.HOUR_OF_DAY);
			System.out.println(x + "  " + y);
			for(;y<calendar2.get(Calendar.HOUR_OF_DAY);y++){
				orderArray[x][y] = orders;
			}
		}
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		//一周周几的数组
		map.put("week", DateUtils.WeekOfDay(new Date()));
		map.put("orderArray", orderArray);
		MessageUtils message = MessageUtils.success(); 
		message.setExtend(map);

		return message;
	}
}