package com.lti.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Student;
import com.lti.service.StudentService;

public class Main2 {
	private static ApplicationContext context;

	public static void main(String[] args) {
		

		context=new AnnotationConfigApplicationContext(AppConfig.class);
		Student student;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Add Student");
		System.out.println("2. Find Student");
		System.out.println("3. Modify Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Get All Students");
		System.out.println("0. Exit Application");
		
		
		StudentService service = (StudentService) context.getBean("service");
		boolean flag = true;
		do{
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			
			switch (choice) {
			
			case 1:
				System.out.println("Enter Student Roll Number");
				int rollNumber = scan.nextInt();
				System.out.println("Enter Student Name");
				String studentName = scan.next();
				System.out.println("Enter Student Score");
				double score = scan.nextDouble();
				student = (Student) context.getBean("student", Student.class);
				student.setRollNumber(rollNumber);
				student.setStudentName(studentName);
				student.setStudentScore(score);
				
				boolean result = service.addStudent(student);
				
				if(result) {
					System.out.println("Student with Roll Number: " + student.getRollNumber() + " has been recorded by us!");
				}
				else{
					System.out.println("There is some technical problem. Please try again later!");
				}
				
				break;
			case 2:
				System.out.println("Enter Roll number to search");
				rollNumber = scan.nextInt();
				student = service.findStudentByRollNumber(rollNumber);
				System.out.println(student);
				break;
			case 3:
				System.out.println("Enter Student Roll Number to update");
				rollNumber = scan.nextInt();
				System.out.println("Enter new Student Name");
				studentName = scan.next();
				System.out.println("Enter  new Student Score");
				score = scan.nextDouble();
				student = (Student) context.getBean("student", Student.class);
				student.setRollNumber(rollNumber);
				student.setStudentName(studentName);
				student.setStudentScore(score);
				
				result = service.updateStudent(student);
				
				if(result){
					System.out.println("Record with roll number: " + student.getRollNumber() + " has been successfully updated ");
				}
				else{
					System.out.println("Records could not be updated! Try Again");
				}
				break;
			case 4:
				System.out.println("Enter RollNumber to Delete");
				rollNumber=scan.nextInt();
				result=service.deleteStudent(rollNumber);
				if(result){
					System.out.println("Record with "+rollNumber+" has been deleted ");
				}
				else{
					System.out.println("RollNumber not found");
				}
				break;
			case 5:
				List<Student> students = service.getAllStudents();
				
				if(students.size() != 0){
					for(Student s: students)
					{
						System.out.println("Roll Number: " + s.getRollNumber());
						System.out.println("Name: " + s.getStudentName());
						System.out.println("Score: " + s.getStudentScore());
						
						if(s.getAddress() != null){
							System.out.println("Address Id: " + s.getAddress().getAddressId());
							System.out.println("City " + s.getAddress().getCity());
						}
						System.out.println("------------------------------");
					}
				}
				else{
					System.out.println("No records in database");
				}
			case 0:
				flag = false;
			}
		}while(flag);
		scan.close();
		System.out.println("exit");
	}

	public static ApplicationContext getContext() {
		return context;
	}
//
//	public static void setContext(ApplicationContext context) {
//		Main2.context = context;
//	}
}
