package com.spring.user.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect 
{
	Logger log = Logger.getLogger(LoggingAspect.class.getName());
	
	 @Before("execution(* com.spring.user.service.UserService.*(..))")
	 public void beforeServiceMethodExecution(JoinPoint joinPoint) 
	 {
	       log.info("Before " + joinPoint.getSignature().getName() + " method");
	 }
	 
	 @AfterReturning(pointcut = "execution(* com.spring.user.service.UserService.*(..))")
	 public void afterServiceMethodExecution(JoinPoint joinPoint) 
	 {
	        log.info("After " + joinPoint.getSignature().getName() + " method");
	       
	 }

}


































