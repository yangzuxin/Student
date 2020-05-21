package com.xiaoan.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcUtil {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static Connection getConn() throws Exception{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	public static Statement getStatement() throws Exception{
		return getConn().createStatement();
	}
	
	public static PreparedStatement getPreState(String sql) throws Exception{
		return getConn().prepareStatement(sql);
	}
	
}