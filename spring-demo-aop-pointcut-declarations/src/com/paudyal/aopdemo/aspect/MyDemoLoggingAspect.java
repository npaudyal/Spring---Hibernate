package com.paudyal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	
	//lets start with @Before
	@Pointcut("execution(* com.paudyal.aopdemo.dao.*.*(..))")
	public void forDAOpackage() {}
	
	
	@Before("forDAOpackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======> Executing @Before advice on addAccount()");
	}

}
