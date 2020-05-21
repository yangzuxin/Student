package com.xiaoan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoan.model.PageModel;
import com.xiaoan.model.StudentModel;
import com.xiaoan.service.impl.StudentImpl;


public class StudentController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String method = req.getParameter("method");
			if(method.equals("addStudent")){
				//���ѧ����Ϣ
				addStudent(req,resp);
			}else if(method.equals("displaystudent")){
				//ѧ����Ϣά��
				displaystudent(req,resp);
			}else if(method.equals("modifyManagerPassword")){
				//�޸�����
				modifyManagerPassword(req,resp);
			}else if(method.equals("queryStudentById")){
				queryStudentById(req,resp);
			}else if(method.equals("updateStudentPage")){
				updateStudentPage(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ѧ����Ϣά��
	private void displaystudent(HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		// TODO Auto-generated method stub
		StudentImpl tssi = new StudentImpl();
		List<StudentModel> stuList =  tssi.queryAllStudent();
		req.setAttribute("list", stuList);
		req.setAttribute("mainPage", "displaystudent.jsp");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
	private void updateStudentPage(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String stId = req.getParameter("stId");
		StudentImpl tssi = new StudentImpl();
		StudentModel ts = tssi.queryTStudentById(stId);
		req.setAttribute("student", ts);
		req.setAttribute("mainPage", "studentUpdate.jsp");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
		
	}
	private void queryStudentById(HttpServletRequest req,
			HttpServletResponse resp)  throws Exception{
		// TODO Auto-generated method stub
		StudentImpl tssi = new StudentImpl();
		String stId = req.getParameter("stId").trim();
		StudentModel ts =  tssi.queryTStudentById(stId);
		req.setAttribute("student", ts);
		req.setAttribute("mainPage", "showstudent.jsp");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
		
	}
	//�޸�����
	private void modifyManagerPassword(HttpServletRequest req,
			HttpServletResponse resp) throws Exception{
		req.setAttribute("mainPage", "modifyManagerPassword.jsp");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
		
	}
	
	
	//���ѧ����Ϣ
	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		req.setAttribute("mainPage", "studentAdd.jsp");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

}
