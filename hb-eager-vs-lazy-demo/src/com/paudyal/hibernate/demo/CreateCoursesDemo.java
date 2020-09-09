package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Course;
import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			
			
			//create some courses
			
			Course tempCo1 = new Course("Air Guitar");
			Course tempCo2 = new Course("Piano");

			
			
			//add those courses to ins
			tempIns.add(tempCo1);
			tempIns.add(tempCo2);
			
			
			//save those courses
			session.save(tempCo1);
			session.save(tempCo2);
			
			
		
		
		
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
