package ex;
/**
 * 김영선
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class DeptManager {


	public List<DeptVO> getDepts()   {
		
		List<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from Dept";
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DeptVO dept = new DeptVO();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				list.add(dept);
			}
			
		} catch (Exception e) {
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
		
	}
	

	
}
