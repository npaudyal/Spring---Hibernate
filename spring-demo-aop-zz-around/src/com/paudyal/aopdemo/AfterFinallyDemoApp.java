package com.paudyal.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paudyal.aopdemo.dao.AccountDAO;
import com.paudyal.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the method to find accounts
		List<Account> theAccounts = null;
		
		try {
		//add a boolean flag to simulate exception
			boolean tripWire = false;
			
		theAccounts = theAccountDAO.findAccounts(tripWire);
		
		} catch(Exception e) {
			System.out.println("\n\nMain Program...caught exception" + e);
		} 
		
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
	}

}









