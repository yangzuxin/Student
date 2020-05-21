package com.xiaoan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoan.model.ManagerTable;
import com.xiaoan.service.impl.ManagerImpl;

public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String username = req.getParameter("username");
			String userpwd = req.getParameter("password");
			ManagerTable tm = new ManagerTable();
			tm.setUsername(username);
			tm.setUserpwd(userpwd);
			ManagerImpl tmsi = new ManagerImpl();
		    int row = tmsi.AddManager(tm);
		    if (0!=row) {
				req.getSession().setAttribute("userName", username);
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
