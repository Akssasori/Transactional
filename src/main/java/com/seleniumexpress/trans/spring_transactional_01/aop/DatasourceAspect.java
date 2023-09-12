package com.seleniumexpress.trans.spring_transactional_01.aop;

import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.ConnectionImpl;

@Component
@Aspect
public class DatasourceAspect {
	
	@Around("target(javax.sql.DataSource)")
	public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		System.out.println("datasource tracker: "+ proceedingJoinPoint.getSignature());
		
		Object returnValue = proceedingJoinPoint.proceed();
		
		if (returnValue instanceof Connection) {
		
		Connection con = (Connection)Proxy.newProxyInstance(
				ConnectionImpl.class.getClassLoader(), 
				new Class[] {Connection.class}, new ConnectionInvocationHandler((Connection)returnValue));
		
		return con;
		
		}
		
		return returnValue;
	}

}
