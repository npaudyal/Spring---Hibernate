package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Course;
import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create objects
			Instructor tempIns = new Instructor("Santi", "Paudel", "shanti01@gmail.com");

			
			
			
			InstructorDetail tempInsD = new InstructorDetail("www.shua.com", "Video games");
			
			
					
			
			
			
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
			session.close();
			factory.close();
		}
		

	}

}
