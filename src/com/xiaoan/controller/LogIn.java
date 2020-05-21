package com.xiaoan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoan.model.ManagerTable;
import com.xiaoan.service.impl.ManagerImpl;

public class LogIn extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	try {
		String userName = req.getParameter("userName");
		String userPwd = req.getParameter("userPwd");
		ManagerImpl tmsi = new ManagerImpl();
		ManagerTable tm = tmsi.queryMangerTable(userName, userPwd);
		if(null!=tm){
			req.getSession().setAttribute("userName", userName);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
