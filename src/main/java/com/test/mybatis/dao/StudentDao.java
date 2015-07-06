package com.test.mybatis.dao;

import java.util.Map;

import com.test.mybatis.entity.Student;

public interface StudentDao {
    public void insertStudent(Student student);
    
	public Student selectStudentById(Map<String,Integer> map);
	
	public void deleteStudentById(Map<String,Integer> map);
	
	public void updateStudentById(Student student);
}
