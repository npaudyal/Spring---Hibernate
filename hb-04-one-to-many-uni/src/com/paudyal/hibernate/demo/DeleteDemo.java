package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;
import com.paudyal.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
		
			
			//start a transaction
			
			session.beginTransaction();
			
			
			int theId =1;
			
			Instructor tempIns = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor: " + tempIns);
			
			if(tempIns !=null) {
				System.out.println("Deleting :" +tempIns);
				
				//also deletes details because of all cascades one to one relation
				session.delete(tempIns);
			} 
			
			
			//save the instructor
			
			
		
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
		

	}

}
