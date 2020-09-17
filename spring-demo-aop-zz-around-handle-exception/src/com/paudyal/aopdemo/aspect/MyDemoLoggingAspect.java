package com.paudyal.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.paudyal.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	@Around("execution(* com.paudyal.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theJoinPoint) throws Throwable {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====> Exectuting @Around on method" + method);
	
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = theJoinPoint.proceed();
		} catch (Exception e) {
			//log the exception
			myLogger.warning(e.getMessage());
			
			//give user a custom message
			result = "Major Accident! But no worries, you private chopper is on the way";
			
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("\n=====> Duration: "+duration/1000.0 + "seconds.");
		
		
		
		return result;
	}
	
	
	@After("execution(* com.paudyal.aopdemo.dao.AccountDAO.findAccounts(..))"
)
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====> Exectuting after finally  on method" + method);
	
		
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.paudyal.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing ="theExc"
			)
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		//print which method we are advising
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====> Exectuting after throwing on method" + method);
	
		myLogger.info("\n ====> Exception is" + theExc);
	}
	
	
	
	//add a new advise for @AfterReturning
	
	@AfterReturning(
			pointcut="execution(* com.paudyal.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")	
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====> Exectuting after returning on method" + method);
		
		//results
		myLogger.info("\n ====>Result is" + result);
		
		//let's post-process the data ... and modify it:
		
		//convert the account name to uppercase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n ====>Result is" + result);
		
		
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//loop trhough the accounts 
		for(Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
		
	
	}


	@Before("com.paudyal.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n=====>>> Executing @Before advice on method");	
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());								

			}
		}
		
	}
	
}










