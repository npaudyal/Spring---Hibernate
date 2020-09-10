package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Course;
import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;
import com.paudyal.hibernate.demo.entity.Review;
import com.paudyal.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
		
			
			
			//start a transaction
			
			session.beginTransaction();
			
			//get the student Mary from db
			int theId =2;
			Student tempS = session.get(Student.class, theId);
			System.out.println("Loaded student: " + tempS);
			System.out.println("Courses: " + tempS.getCourses());
			
			//create more courses
			Course tempCourse1= new Course("Rubiks cube - How to speed cube");
			Course tempCourse2= new Course("Attari 2600- Game Development");
			
			
			
			//add mary to those courses
			tempCourse1.addStudent(tempS);
			tempCourse2.addStudent(tempS);
			
			
			System.out.println("Saving the courses");
			
			
			session.save(tempCourse1);
			session.save(tempCourse2);
		
		
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
