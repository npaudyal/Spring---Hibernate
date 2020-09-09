package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;
import com.paudyal.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create objects
			Instructor tempIns = new Instructor("Madhi", "Patel", "mpatel01@gmail.com");

			
			
			
			InstructorDetail tempInsD = new InstructorDetail("www.patel.com", "Guitar");
			
			
					
			
			
			
			//associate objects
			tempIns.setInstructorDetail(tempInsD);
			
			
			
			
			
			//start a transaction
			
			session.beginTransaction();
			
			
			//save the instructor
			System.out.println("Saving instructor: " + tempIns);
			session.save(tempIns);
			
		
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
		

	}

}
