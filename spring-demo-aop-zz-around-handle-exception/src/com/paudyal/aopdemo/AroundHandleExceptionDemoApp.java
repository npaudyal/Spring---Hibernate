package com.paudyal.aopdemo;



import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paudyal.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		myLogger.info("\nMain program : AroundDemoAPP");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("My fortune is: "+data);
		
		// close the context
		
		
		context.close();
	}

}









