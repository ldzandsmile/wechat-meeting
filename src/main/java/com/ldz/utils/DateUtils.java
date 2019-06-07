package com.ldz.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/*
 * 一些关于时间的工具类
 */
public class DateUtils {

	/*
	 * 计算输入时间与当前时间的前后关系
	 * 参数： Date time
	 * 返回值： boolean   
	 * 		true-输入时间在当前时间之前
	 * 		false-输入时间在当前时间之后
	 */
	public static boolean CompareTime(Date time){
		if(time.getTime() > new Date().getTime()){
			return false;
		} else {
			return true;
		}
	}
	
	
	/*
	 * 将 Date 类型时间转化成 String 类型  
	 * 参数：Date time
	 * 返回值：String    yyyy-MM-dd HH:mm:ss
	 */
	public static String DateToString(Date time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(time);
	}
	
	/*
	 * 获取输入时间当天的开始
	 * 参数：Date time
	 * 返回值：Date
	 */
	public static Date StartTimeOfDay(Date time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		calendar.set(Calendar.MINUTE, 0);  
		calendar.set(Calendar.SECOND, 0);  
		return calendar.getTime();
	}
	
	/*
	 * 获取输入时间当天的结束时间
	 * 参数：Date time
	 * 返回值：Date
	 */
	public static Date EndTimeOfDay(Date time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.HOUR_OF_DAY, 23);  
		calendar.set(Calendar.MINUTE, 59);  
		calendar.set(Calendar.SECOND, 59);  
		return calendar.getTime();
	}
	
	/*
	 * 获取接下来一周是周几
	 * 参数：Date time
	 * 返回值：String[]
	 */
	public static String[] WeekOfDay(Date time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		
		String[] week = new String[7];
		
		switch(calendar.get(Calendar.DAY_OF_WEEK)){
		case 1: 
			String[] week1 = {"日", "一", "二", "三", "四", "五", "六"}; 
			week = week1; 
			break;
		case 2: 
			String[] week2 = {"一", "二", "三", "四", "五", "六", "日"}; 
			week = week2; 
			break;
		case 3: 
			String[] week3 = {"二", "三", "四", "五", "六", "日", "一"};
			week = week3; 
			break;
		case 4: 
			String[] week4 = {"三", "四", "五", "六", "日", "一", "二"};
			week = week4; 
			break;
		case 5: 
			String[] week5 = {"四", "五", "六", "日", "一", "二", "三"};
			week = week5; 
			break;
		case 6: 
			String[] week6 = {"五", "六", "日", "一", "二", "三", "四"};
			week = week6; 
			break;
		case 7: 
			String[] week7 = {"六", "日", "一", "二", "三", "四", "五"};
			week = week7; 
			break;
		}
		
		return week;
	} 
	
	@Test
	public void test(){
		System.out.println(DateUtils.WeekOfDay(new Date(new Date().getTime() - 2*24*60*60*1000))[0]);
	}
}
