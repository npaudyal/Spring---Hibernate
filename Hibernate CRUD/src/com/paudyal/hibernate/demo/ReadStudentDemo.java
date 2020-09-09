package com.paudyal.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			
			//start a transaction
			
			session.beginTransaction();
			
			//query the student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			
			//display the students
			displayStudents(theStudents);
			
			
			theStudents = session.createQuery("from Student s where s.lastName='Paudyal'").getResultList();
			displayStudents(theStudents);
			System.out.println("Desired student: " + theStudents);
			
			
			
			
			//commit the transaction
			
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
