package com.seleniumexpress.trans.spring_transactional_01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTraker {
	
	
	@Pointcut("within(com..service.*) || within(com..repo.*)")
	public void logMethodPointCut() {
		
	}
	
	@Around("logMethodPointCut()")
	public Object LogBeforeMethodCall(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
		
		//before
		String name = proceedingJoinPoint.getSignature().getName();
		
		System.out.println("method strat: " + name);
		
		//call to your method
		Object returnValue = proceedingJoinPoint.proceed(); //saveProductInfo
//		System.out.println(returnValue);
		
		//after the method executed
		System.out.println("method completed: " + name);
		
		return returnValue;
		
	}
	
	
//	@Before("logMethodPointCut()")
//	public void LogBeforeMethodCall() {
//		System.out.println("method is starting...");
//		
//	}
//	
//	@After("logMethodPointCut()")
//	public void LogAfterMethodCall() {
//		System.out.println("method is completed...");
//		
//	}

}
