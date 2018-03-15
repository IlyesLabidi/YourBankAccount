package com.hellocontroller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	Calendar cal = Calendar.getInstance();
	int dayOfweek=cal.get(cal.DAY_OF_WEEK); // getting the day on which request is made
	if(dayOfweek==1){
		response.getWriter().write("the website is closing on Sunday; please try accessing it on any other day");
		return false ; 
	}
	return true ;
}
}
