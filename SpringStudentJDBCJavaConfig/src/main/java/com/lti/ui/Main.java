package com.lti.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.model.Student;
import com.lti.service.StudentService;

public class Main {

	public static void main(String[] args) {
		// ApplicationContext context = new FileSystemXmlApplicationContext("");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		StudentService service = context.getBean("service", StudentService.class);
		//you have to receive data from user if you want to store the real data
		Student s1 = context.getBean("student", Student.class);
		
		s1.setRollNumber(69);
		s1.setStudentName("Baburao");
		s1.setStudentScore(56);
		
		boolean result = service.addStudent(s1);
		if (result) {
			System.out.println("Student is added");
//			Student s2=service.findStudentByRollNumber(s1.getRollNumber());
//			System.out.println(s2);
//			System.out.println(s2.getAddress());
		} else {
			System.out.println("Student is not added");
		}

	}

}
