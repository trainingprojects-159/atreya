package com.mphasis.atreya.configurations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHelper {

	@Before("execution(* com.mphasis.atreya.*.*.*(..))")
	public void beforeMethods(JoinPoint joinpoint) {
		//class name and method-name
		System.out.println(joinpoint.getSignature());
		//only method-name
		System.out.println(joinpoint.getSignature().getName());
	}
	
	@After("execution(* com.mphasis.atreya.*.*.*(..))")
	public void afterMethods(JoinPoint joinpoint) {
		//class name and method-name
		System.out.println("after"+joinpoint.getSignature());
		//only method-name
		System.out.println(joinpoint.getSignature().getName());
	}
}
