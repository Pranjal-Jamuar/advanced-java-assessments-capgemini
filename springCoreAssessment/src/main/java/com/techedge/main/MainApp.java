package com.techedge.main;

import com.techedge.config.MyConfig;
import com.techedge.entity.Department;
import com.techedge.entity.Student;
import com.techedge.service.UniversityService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityService dservice =
                context.getBean(UniversityService.class);

        // Create Departments
        Department d1 = new Department();
        d1.setName("Postgres");
        dservice.saveDepartemnt(d1);

        Department d2 = new Department();
        d2.setName("Java Core");
        dservice.saveDepartemnt(d2);

        // Assign Student to Department 1
        Student s1 = new Student();
        s1.setName("Ramesh");
        s1.setEmail("ramesh@email.com");

        dservice.assignStudent(s1, 1);

        System.out.println(dservice.getallStudents(1));
        System.out.println(dservice.findDepartmentByID(1));

        ((AnnotationConfigApplicationContext) context).close();
    }
}