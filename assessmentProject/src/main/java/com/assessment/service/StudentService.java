package com.assessment.service;

import com.assessment.dao.StudentDAO;
import com.assessment.entity.Course;
import com.assessment.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.assessment.util.JPAUtil;


public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public int createSampleData() {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        int firstId = 0;

        try {

            tx.begin();

            Student s1 = new Student("Rahul");
            Student s2 = new Student("Sneha");
            Student s3 = new Student("Arjun");

            Course c1 = new Course("Data Structures");
            Course c2 = new Course("Database Systems");
            Course c3 = new Course("Operating Systems");

            s1.addCourse(c1);
            s1.addCourse(c2);

            s2.addCourse(c2);
            s2.addCourse(c3);

            s3.addCourse(c1);
            s3.addCourse(c3);

            em.persist(s1);
            em.persist(s2);
            em.persist(s3);

            tx.commit();

            firstId = s1.getId();

            System.out.println("Sample data inserted successfully.");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        return firstId;
    }




    
    public void fetchStudent(int id) {

        Student student = studentDAO.getById(id);

        System.out.println("Student Name: " + student.getName());

        student.getCourses().forEach(course ->
                System.out.println("Course: " + course.getTitle())
        );
    }
    
    public void updateStudentName(int id, String newName) {

        Student student = studentDAO.getById(id);

        if (student != null) {
            student.setName(newName);
            studentDAO.update(student);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    
    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }
    
    public void giveCourseToStudent(int studentId, int courseId) {
        studentDAO.giveCourseToStudent(studentId, courseId);
    }




}
