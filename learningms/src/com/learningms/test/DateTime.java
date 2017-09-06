package com.learningms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateTime {
	/*
	 * 
	 * 处理时间的函数
	 * 
	 */
	@Test
	public void proDatetime() throws ParseException {
		/*
		 * 1.Date类型与String类型相互转换，获得指定格式的日期
		 */
		SimpleDateFormat formatDate = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		String dateToString = formatDate.format(new Date());
		System.out.println(dateToString);

		Date stringToDate = formatDate.parse("2017-08-01 09:09:10");
		System.out.println(stringToDate);
		
		System.out.println(checkDate(stringToDate,new Date()));

		/*
		 * 2.Date类型与long类型相互转换，获得毫秒数
		 */
		long dateToLong = new Date().getTime();
		System.out.println(dateToLong);

		Date longToDate = new Date(dateToLong);
		System.out.println(longToDate);

		/*
		 * 3.Date类型与Calendar类型相互转换，用Date设置Calendar的值
		 */
		Calendar dateToCalendar = Calendar.getInstance();
		dateToCalendar.setTime(new Date());
		System.out.println(dateToCalendar);

		Date calendarToDate = Calendar.getInstance().getTime();
		System.out.println(calendarToDate);

	}
	
	/*
	 * 用于比较两个时间的先后关系
	 * int i = start.compareTo(end);
	 * 1.start = end , i=0;
	 * 2.start < end , i=-1;
	 * 3.start > end , i=1.
	 */
	public boolean checkDate(Date start, Date end) {
		boolean ret = true;
		ret = start.compareTo(end) < 0;
		return ret;
	}
	
	/*
	 * 获取两个时间间的差值，包含：天，时，分。
	 */
	
	public long[] getDiffHour(Date start, Date end) {
		long time1 = start.getTime();  
		long time2 = end.getTime();  
        long day = 0;  
        long hour = 0; 
        long min = 0; 
		long diff ;  
        if (time1 < time2) {  
            diff = time2 - time1;  
        } else {  
            diff = time1 - time2;  
        } 
        
        day = diff / (24 * 60 * 60 * 1000);  
        hour = (diff / (60 * 60 * 1000) - day * 24);  
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
        long[] times = {hour, min, day};  
        return times; 

	}
}
