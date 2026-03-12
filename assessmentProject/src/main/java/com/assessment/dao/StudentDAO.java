package com.assessment.dao;

import com.assessment.entity.Course;
import com.assessment.entity.Student;
import com.assessment.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentDAO {

    public void save(Student student) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Student getById(int id) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Student student = null;

        try {
            student = em.find(Student.class, id);
            if (student != null) {
                student.getCourses().size(); // initialize
            }
        } finally {
            em.close();
        }

        return student;
    }

    public void update(Student student) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
                System.out.println("Student deleted successfully.");
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void giveCourseToStudent(int studentId, int courseId) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Student student = em.find(Student.class, studentId);
            Course course = em.find(Course.class, courseId);

            if (student != null && course != null) {
                student.addCourse(course);
            }

            tx.commit();
            System.out.println("Course assigned successfully.");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
