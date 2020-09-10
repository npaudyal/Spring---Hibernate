package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Course;
import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;
import com.paudyal.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
		
			
			
			//start a transaction
			
			session.beginTransaction();
			
			//create a course
			Course tempC = new Course("Pacman - How to Play");
			
			
			
			//add some reviews
			tempC.addReview(new Review("Great course...loved it"));
			tempC.addReview(new Review("Cool course...Well done"));
			tempC.addReview(new Review("what a dumb ass..."));
			
			
			
			//save the course and leverage the cascade all
			System.out.println("saving courtse");
			
			System.out.println(tempC);
			
			
			System.out.println(tempC.getReviews());
			session.save(tempC);
			
			
		
		
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
