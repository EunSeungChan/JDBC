package test.hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class EmpTest {
	public static void main(String[] args) {
		
		System.out.println("** Emp Test **");
		String sql = "select count(*) 직속부하직원수, e.employee_id 관리자사번, e.last_name 관리자이름 " + 
				"from employees e join employees m " + 
				"on e.employee_id = m.manager_id " + 
				"group by e.employee_id,e.last_name " + 
				"having count(*) > 7 " + 
				"order by count(*)" ;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		
			con = JDBCUtil.getConnection();
			//st = con.createStatement();
			ps = con.prepareStatement(sql); 
			
			// ? 세팅작업
			
			//실행
			rs = ps.executeQuery();
			
			//결과값 핸들링
			while (rs.next()) {
				System.out.print(rs.getInt("직속부하직원수")+"   ");
				System.out.print(rs.getInt("관리자사번")+"   ");
				System.out.print(rs.getString("관리자이름")+"   ");
				System.out.println();
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		System.out.println("** end **");
	}

}
