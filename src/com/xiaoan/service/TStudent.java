package com.xiaoan.service;

import java.util.List;

import com.xiaoan.model.StudentModel;

public interface TStudent {
	public StudentModel queryTStudentById(String stId) throws Exception;
	public int insertStudent(StudentModel ts) throws Exception;
	public int updateStudentById(StudentModel ts) throws Exception;
	public int deleteStudentById(String stId) throws Exception;
	public List<StudentModel> queryAllStudent() throws Exception;
}
