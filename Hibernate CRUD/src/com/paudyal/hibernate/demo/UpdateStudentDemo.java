package com.paudyal.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId=1;
			
			session = factory.getCurrentSession();
			
			
			//start a transaction
			
			session.beginTransaction();
			
			System.out.println("Getting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Get complete: " + myStudent);
			
		
		
			
			
			session.createQuery("delete from Student where id =2").executeUpdate();
			
			
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
