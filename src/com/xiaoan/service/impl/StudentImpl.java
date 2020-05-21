package com.xiaoan.service.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.xiaoan.jdbc.util.JdbcUtil;
import com.xiaoan.model.StudentModel;
import com.xiaoan.service.TStudent;
public class StudentImpl implements TStudent {

	@Override
	public StudentModel queryTStudentById(String stId) throws Exception {
		String sql = "select * from t_student where stid=?";
		PreparedStatement ps = JdbcUtil.getPreState(sql);
		ps.setString(1, stId);
		ResultSet rs = ps.executeQuery();
		StudentModel ts = new StudentModel();
		while (rs.next()) {
			ts.setStid(rs.getString("stid"));
			ts.setStname(rs.getString("stname"));
			ts.setStsex(rs.getString("stsex"));
			ts.setStage(rs.getString("stage"));
			ts.setSttel(rs.getString("sttel"));
			ts.setStdept(rs.getString("stdept"));
			ts.setStaddress(rs.getString("staddress"));
		}
		return ts;
	}

	@Override
	public int insertStudent(StudentModel ts) throws Exception {
		String sql = "insert into t_student values(stu_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement ps = JdbcUtil.getPreState(sql);
		ps.setString(1, ts.getStname());
		ps.setString(2, ts.getStsex());
		ps.setString(3, ts.getStage());
		ps.setString(4, ts.getSttel());
		ps.setString(5, ts.getStdept());
		ps.setString(6, ts.getStaddress());
		int rows = ps.executeUpdate();
		return rows;
	}

	@Override
	public int updateStudentById(StudentModel ts) throws Exception {
		String sql = "update t_student set stname=?,stsex=?,stage=?,sttel=?,stdept=?,staddress=? where stid=?";
		PreparedStatement ps = JdbcUtil.getPreState(sql);
		ps.setString(1, ts.getStname());
		ps.setString(2, ts.getStsex());
		ps.setString(3, ts.getStage());
		ps.setString(4, ts.getSttel());
		ps.setString(5, ts.getStdept());
		ps.setString(6, ts.getStaddress());
		ps.setString(7, ts.getStid());
		int rows = ps.executeUpdate();
		return rows;
	}

	@Override
	public int deleteStudentById(String stId) throws Exception {
		String sql = "delete from t_student where stid=?";
		PreparedStatement ps = JdbcUtil.getPreState(sql);
		ps.setString(1, stId);
		int rows = ps.executeUpdate();
		return rows;
	}

	@Override
	public List<StudentModel> queryAllStudent() throws Exception {
		List<StudentModel> stuList = new ArrayList<StudentModel>();
		String sql = "select * from t_student order by stid";
		PreparedStatement ps = JdbcUtil.getPreState(sql);
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
		return stuList;
	}
}
