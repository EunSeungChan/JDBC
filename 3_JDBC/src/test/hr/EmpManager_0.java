package test.hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class EmpManager_0 {
//리스크 드롭박스
//	public static void printEmployee(String jobs[])  {
//	
//}
	
	public static void main(String[] args) {
	
		String sql = "select e.employee_id, e.first_name, e.salary " + 
				"from employees e join jobs j " + 
				"on e.job_id = j.job_id " + 
				"where j.job_title in(?,?)" ;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		try {
			
			con = JDBCUtil.getConnection();
					
			ps = con.prepareStatement(sql); 
			//sql을 미리 컴파일 , st = con.createStatement(); 보다 성능이 더 좋음
			
			// ? 세팅작업
			ps.setString(1, "President");
			ps.setString(2, "Programmer");

			//실행
			rs = ps.executeQuery();
			
			//결과값 핸들링
			
			while(rs.next()) {
				System.out.print(rs.getString("employee_id")+"   ");
				System.out.print(rs.getString("first_name")+"   ");
				System.out.print(rs.getString("salary")+"   ");
				System.out.println();
			}
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

}


