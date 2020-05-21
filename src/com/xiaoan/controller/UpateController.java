package com.xiaoan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoan.model.StudentModel;
import com.xiaoan.service.impl.StudentImpl;

public class UpateController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String stId = req.getParameter("stId").trim();
			String stName = req.getParameter("stName");
			String stSex = req.getParameter("stSex");
			String stAge = req.getParameter("stAge");
			String stTel = req.getParameter("stTel");
			String stDept = req.getParameter("stDept");
			String stAddress = req.getParameter("stAddress");
			StudentModel ts = new StudentModel();
			ts.setStid(stId);
			ts.setStname(stName);
			ts.setStsex(stSex);
			ts.setStage(stAge);
			ts.setSttel(stTel);
			ts.setStdept(stDept);
			ts.setStaddress(stAddress);
			StudentImpl tssi = new StudentImpl();
			int rows;
			rows = tssi.updateStudentById(ts);
			if (rows != 0) {
				List<StudentModel> stuList = tssi.queryAllStudent();
				req.setAttribute("list", stuList);
				req.setAttribute("mainPage", "displaystudent.jsp");
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
