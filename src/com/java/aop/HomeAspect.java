package com.java.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

public class HomeAspect {

	public static Logger logger = Logger.getLogger(HomeAspect.class.getName());
	
	public static final String logMsg = "LogMsg---------------";
	
	public Object advice(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
