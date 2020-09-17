package com.paudyal.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paudyal.aopdemo.dao.AccountDAO;
import com.paudyal.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the method to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterREturningDemoApp");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
	}

}









