package com.paudyal.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paudyal.aopdemo.dao.AccountDAO;
import com.paudyal.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//read spring config java class
		AnnotationConfigApplicationContext context = 
									new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		
		
		
		
		//call the business method
		theAccountDAO.addAccount();
		theMembershipDAO.addAccount();
		//do it again!
		
		
		System.out.println("\n lets call it again!");
		
		theAccountDAO.addAccount();
		theMembershipDAO.addAccount();
		//close the contxt
		context.close();
		
	}

}
