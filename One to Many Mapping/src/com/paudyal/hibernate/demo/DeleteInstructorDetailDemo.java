package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;
import com.paudyal.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			
			int theId =3;
			
			InstructorDetail tempInsD = session.get(InstructorDetail.class, theId);
			
			
			System.out.println("tempInsD: " + tempInsD);
			
			System.out.println("Associated Inst: " + tempInsD.getInstructor());
		
			tempInsD.getInstructor().setInstructorDetail(null);
			session.delete(tempInsD);
			
	
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
				catch (Exception e) {
					e.printStackTrace();
				}
		
		finally {
			session.close();
			factory.close();
		}
		

	}

}
