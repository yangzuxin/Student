package com.xiaoan.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.catalina.Manager;

import com.xiaoan.jdbc.util.JdbcUtil;
import com.xiaoan.model.ManagerTable;
import com.xiaoan.service.TManager;


public class ManagerImpl implements TManager  {
//µÇÂ¼
	@Override
	public ManagerTable queryMangerTable(String username, String userpwd)
			throws Exception {
		String sql = "select * from t_manager where username=? and userpwd=?";
		PreparedStatement ps = JdbcUtil.getPreState(sql);
		ps.setString(1,username);
		ps.setString(2, userpwd);
		ResultSet rs = ps.executeQuery();
		ManagerTable tm = new ManagerTable();
		while (rs.next()) {
			String userNameQuery = rs.getString("userName");
			String userPwdQuery = rs.getString("userPwd");
			tm.setUsername(userNameQuery);
			tm.setUserpwd(userPwdQuery);
			return tm;
		}
		
		return null;
	}
//×¢²á
	@Override
	public int AddManager(ManagerTable tm) throws Exception {
		String sql = "insert into t_manager values (man_seq.nextval,?,?) ";
		PreparedStatement ps = JdbcUtil.getPreState(sql);
		ps.setString(1, tm.getUsername());
		ps.setString(2, tm.getUserpwd());
		int row = ps.executeUpdate();
		return row;
	}

}
