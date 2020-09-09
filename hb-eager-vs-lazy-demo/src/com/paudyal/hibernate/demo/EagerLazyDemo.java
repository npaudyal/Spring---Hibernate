package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Course;
import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
		
			
			
			//start a transaction
			
			session.beginTransaction();
			
			//get the instructor from db
			int theId=1;
			Instructor tempIns = session.get(Instructor.class, theId);
			
			System.out.println("luv2code: Instructor: " +tempIns);
			
			System.out.println("luv2code: Courses: " +tempIns.getCourses());			
			
		
		
			//commit the transaction
			session.getTransaction().commit();
			
			
		
			
			
			
			System.out.println("luv2code: Done");
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
