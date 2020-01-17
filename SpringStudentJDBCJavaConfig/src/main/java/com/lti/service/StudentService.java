package com.lti.service;

import java.util.List;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public Student findStudentByRollNumber(int rollNumber);
	public boolean updateStudent(Student student);
	public boolean deleteStudent(int rollNumber);
	public List<Student> getAllStudents();

}
