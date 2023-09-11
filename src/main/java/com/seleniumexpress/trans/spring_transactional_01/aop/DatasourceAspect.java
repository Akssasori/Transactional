package com.seleniumexpress.trans.spring_transactional_01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DatasourceAspect {
	
	@Around("target(javax.sql.DataSource)")
	public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		System.out.println("datasource tracker: "+ proceedingJoinPoint.getSignature());
		
		Object proceed = proceedingJoinPoint.proceed();
		return proceed;
	}

}
