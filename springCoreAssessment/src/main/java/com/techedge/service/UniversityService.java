package com.techedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techedge.dao.UniversityDao;
import com.techedge.entity.Department;
import com.techedge.entity.Student;

@Component
public class UniversityService {
	@Autowired
	private UniversityDao departmentDao;
	public void saveDepartemnt(Department d) {
		departmentDao.saveDepartemnt(d);
	}
	public void assignStudent(Student s, int id) {
		departmentDao.assignStudent(s, id);
	}
	public void updateName(int id, String name) {
		departmentDao.updateName(id, name);
	}
	public void deleteDepartmentByID(int id) {
		departmentDao.deleteDepartmentByID(id);
	}
	public Department findDepartmentByID(int id) {
		return departmentDao.findDepartmentByID(id);
	}
	public List<Student> getallStudents(int id) {
		return departmentDao.getallStudents(id);
	}
	
	public void testLazyLoading(int id) {
	    departmentDao.testLazyLoading(id);
	}
}