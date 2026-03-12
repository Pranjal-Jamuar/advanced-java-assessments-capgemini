package com.assessment.dao;

import com.assessment.entity.Course;
import com.assessment.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CourseDAO {

    public void save(Course course) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(course);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Course getById(int id) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Course course = null;

        try {
            course = em.find(Course.class, id);
            if (course != null) {
                course.getStudents().size(); // initialize
            }
        } finally {
            em.close();
        }

        return course;
    }

    public void update(Course course) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(course);
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

            Course course = em.find(Course.class, id);
            if (course != null) {
                em.remove(course);
                System.out.println("Course deleted successfully.");
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
