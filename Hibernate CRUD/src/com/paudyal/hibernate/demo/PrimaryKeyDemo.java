package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
				//create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				
				//create a session
				Session session = factory.getCurrentSession();
				
				try {
					
					//create 3 student objects
					System.out.println("Creating 3 student objects...");
					Student tempStudent = new Student("Paul", "Wall", "npaudyal@gmail.com");
					Student tempStudent2 = new Student("Nischal", "Paudyal", "npaudyal01@gmail.com");
					Student tempStudent3= new Student("Man", "che", "npaudyal@gmail.com");

					
					//start a transaction
					
					session.beginTransaction();
					
					//save the student
					
					System.out.println("Saving students...");
					session.save(tempStudent);
					session.save(tempStudent2);
					session.save(tempStudent3);

					//commit the transaction
					session.getTransaction().commit();
					System.out.println("Done");
					
				} finally {
					factory.close();
				}
		

	}

}
