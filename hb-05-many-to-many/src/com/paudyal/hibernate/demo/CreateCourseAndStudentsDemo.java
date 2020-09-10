package com.paudyal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.paudyal.hibernate.demo.entity.Course;
import com.paudyal.hibernate.demo.entity.Instructor;
import com.paudyal.hibernate.demo.entity.InstructorDetail;
import com.paudyal.hibernate.demo.entity.Review;
import com.paudyal.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//create a course
			Course tempC = new Course("Pacman - How to Play");
			
			session.save(tempC);
			
			
			//create students
			Student tempS = new Student("John", "Doe" , "johndoe@gmail.com");
			Student tempS1 = new Student("Mary", "Poppins" , "iamahoe@gmail.com");
			//add students
			tempC.addStudent(tempS);
			tempC.addStudent(tempS1);
			
			//save students
			System.out.println("Saving students");
			
			session.save(tempS);
			session.save(tempS1);
			System.out.println("Saved students:" + tempC.getStudents());
			
			
		
		
		
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
