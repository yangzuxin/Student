package com.xiaoan.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoan.jdbc.util.JdbcUtil;
import com.xiaoan.model.PageModel;
import com.xiaoan.model.StudentModel;
import com.xiaoan.service.impl.StudentImpl;

public class Page extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			int currentPage = Integer.parseInt(req.getParameter("currentPage").trim());
			int totalRows = Integer.parseInt(req.getParameter("totalRows").trim());
			int pageNum = Integer.parseInt(req.getParameter("pageNum").trim());
			List<StudentModel> stuList = new ArrayList<StudentModel>();
			StudentImpl tssi = new StudentImpl();
			List<StudentModel> list = tssi.queryAllStudent();
			// pageNum*currentPage+1 (pageNum*(currentPage+1)+1)
			String sql = "SELECT a.* ,rownum from (select t.*,rownum  as ronum from t_student t where rownum < ?) a where ronum > ?";
			PreparedStatement ps = JdbcUtil.getPreState(sql);
			ps.setInt(2, pageNum*currentPage);
			ps.setInt(1, (pageNum*(currentPage+1)+1));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentModel ts = new StudentModel();
				ts.setStid(rs.getString("stid"));
				ts.setStname(rs.getString("stName"));
				ts.setStsex(rs.getString("stsex"));
				ts.setStage(rs.getString("stage"));
				ts.setSttel(rs.getString("sttel"));
				ts.setStdept(rs.getString("stdept"));
				ts.setStaddress(rs.getString("staddress"));
				stuList.add(ts);
			}
			req.setAttribute("list", stuList);
			PageModel page = new PageModel();
			page.setFirstNum(pageNum*currentPage+1);
			page.setLastNum(pageNum*(currentPage+1) > list.size()?list.size():pageNum*(currentPage+1));
			page.setTotalRows(totalRows);
			page.setCurrentPage(currentPage+1);
			page.setPageNum(pageNum);
			page.setTotalPage(list.size()/pageNum + 1);
			req.setAttribute("page", page);
			req.setAttribute("mainPage", "displaystudent.jsp");
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
