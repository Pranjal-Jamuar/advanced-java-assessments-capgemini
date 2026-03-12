package com.assessment;

import com.assessment.service.StudentService;
import com.assessment.service.CourseService;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        int studentId = studentService.createSampleData();

        studentService.fetchStudent(studentId);

        studentService.updateStudentName(studentId, "Rahul Updated");
        studentService.fetchStudent(studentId);

        studentService.giveCourseToStudent(studentId, 2);

        studentService.deleteStudent(studentId);

        courseService.createCourse("Machine Learning");
        courseService.fetchCourse(1);
    }
}
