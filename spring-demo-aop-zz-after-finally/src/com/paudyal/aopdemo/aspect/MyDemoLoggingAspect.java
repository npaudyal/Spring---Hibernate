package com.paudyal.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.paudyal.aopdemo.dao.AccountDAO.findAccounts(..))"
)
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ====> Exectuting after finally  on method" + method);
	
		
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.paudyal.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing ="theExc"
			)
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		//print which method we are advising
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ====> Exectuting after throwing on method" + method);
	
		System.out.println("\n ====> Exception is" + theExc);
	}
	
	
	
	//add a new advise for @AfterReturning
	
	@AfterReturning(
			pointcut="execution(* com.paudyal.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")	
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ====> Exectuting after returning on method" + method);
		
		//results
		System.out.println("\n ====>Result is" + result);
		
		//let's post-process the data ... and modify it:
		
		//convert the account name to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n ====>Result is" + result);
		
		
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
		
		System.out.println("\n=====>>> Executing @Before advice on method");	
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());								

			}
		}
		
	}
	
}










