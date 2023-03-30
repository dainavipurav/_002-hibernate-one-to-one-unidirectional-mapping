package com.abc.learning.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.learning.entity.Student;
import com.abc.learning.entity.StudentDetails;

public class StudentDao {
	public static String insertStudent(Student student, SessionFactory factory) {
		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			session.persist(student);

			session.getTransaction().commit();

			return "Student inserted successfully";

		} catch (Exception e) {
			e.printStackTrace();
			return "Student insertion failed";
		} finally {
			session.close();
		}
	}

	public static String updateStudent(SessionFactory factory, int id, Student student) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Student student2 = session.get(Student.class, id);

			student2.setName(student.getName());
			student2.setAge(student.getAge());
			student2.setEmail(student.getEmail());

			StudentDetails studentDetails = student2.getStudentDetails();
			studentDetails.setCollegeName(student.getStudentDetails().getCollegeName());
			studentDetails.setStream(student.getStudentDetails().getStream());

			session.update(student2);

			session.getTransaction().commit();

			return "Record updated succefully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Can't update record";
		} finally {
			session.close();
		}
	}

	public static String deleteStudent(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Student student = session.find(Student.class, id);

			session.delete(student);

			session.getTransaction().commit();

			return "Record deleted succefully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Can't delete record";
		} finally {
			session.close();
		}
	}

	public static Student getStudentById(SessionFactory factory,int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, id);
			
			session.getTransaction().commit();
			
			return student;
			
		}  catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}
