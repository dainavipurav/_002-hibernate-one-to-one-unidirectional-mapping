package com.abc.learning.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abc.learning.dao.StudentDao;
import com.abc.learning.entity.Student;
import com.abc.learning.entity.StudentDetails;

public class StudentController {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()//
				.configure("hibernate.cfg.xml")//
				.addAnnotatedClass(Student.class)//
				.addAnnotatedClass(StudentDetails.class)//
				.buildSessionFactory();

//		Insert Record
//		Student student = new Student("Tajammul Shaik", 26, "abhay.khan@cmss.in");
//		StudentDetails studentDetails = new StudentDetails("Rajiv Gandhi","BE");
//		student.setStudentDetails(studentDetails);
//		StudentDao.insertStudent(student, factory);
//		Insert Record

//		Read Record
//		int id = 1;
//		Student student = StudentDao.getStudentById(factory, id);
//
//		if (student == null) {
//			System.out.println("Student not found");
//		} else {
//			System.out.println("Student Details : " + student.toString());
//		}
//		Read Record

//		Update Record
//		int id= 4;
//		Student student = new Student("Tajammul Shaik",26,"tajammul.shaik@cmss.in");
//		StudentDetails studentDetails = new StudentDetails("ABCD","BE");
//		student.setStudentDetails(studentDetails);
//		System.out.println(StudentDao.updateStudent(factory, id, student));
//		Update Record

//		Delete Record
//		int id = 2;
//		System.out.println(StudentDao.deleteStudent(factory, id));
//		Delete Record
		
//		Read list of records by query
		String query = "FROM Student";
		List<Student> list = StudentDao.getStudentListByQuery(factory, query);
		if(list.isEmpty()) {
			System.out.println("No records found");
		}else {
			for(Student student : list) {
				System.out.println(student.toString());
			}
		}
//		Read list of records by query
		
		factory.close();
	}
}
