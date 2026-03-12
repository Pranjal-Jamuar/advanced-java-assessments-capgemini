package com.assessment.service;

import com.assessment.dao.CourseDAO;
import com.assessment.entity.Course;

public class CourseService {

    private CourseDAO courseDAO = new CourseDAO();

    public void createCourse(String title) {
        Course course = new Course(title);
        courseDAO.save(course);
        System.out.println("Course created successfully.");
    }

    public void fetchCourse(int id) {
        Course course = courseDAO.getById(id);

        if (course != null) {
            System.out.println("Course Title: " + course.getTitle());
            course.getStudents().forEach(student ->
                    System.out.println("Student: " + student.getName())
            );
        } else {
            System.out.println("Course not found.");
        }
    }

    public void updateCourse(int id, String newTitle) {
        Course course = courseDAO.getById(id);

        if (course != null) {
            course.setTitle(newTitle);
            courseDAO.update(course);
            System.out.println("Course updated successfully.");
        }
    }

    public void deleteCourse(int id) {
        courseDAO.delete(id);
    }
}
