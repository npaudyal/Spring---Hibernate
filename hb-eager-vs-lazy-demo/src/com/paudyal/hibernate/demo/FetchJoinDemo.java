package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.paudyal.hibernate.demo.entity.Course;
import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "+ "JOIN FETCH i.courses "+ "where i.id=:theInstructorId", Instructor.class);
			
			query.setParameter("theInstructorId", theId);
			
			Instructor tempIns = query.getSingleResult();
			System.out.println("luv2code: Instructor: " +tempIns);
			
			
		
		
			//commit the transaction
			session.getTransaction().commit();
			
			session.close();
		
			
			
			
			System.out.println("luv2code: Done");
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
