package com.xiaoan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoan.model.StudentModel;
import com.xiaoan.service.impl.StudentImpl;

public class DeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String stId = req.getParameter("stId");
			StudentImpl tssi = new StudentImpl();
			int rows = tssi.deleteStudentById(stId);
			if (rows != 0) {
				List<StudentModel> stuList = tssi.queryAllStudent();
				req.setAttribute("list", stuList);
				req.setAttribute("mainPage", "displaystudent.jsp");
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
