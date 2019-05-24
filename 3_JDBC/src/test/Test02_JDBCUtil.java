package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class Test02_JDBCUtil {
	public static void main(String[] args) {

		//emp table에서 부서별 평균 급여(소수점두자리)와 인원수를 구해서 출력하세요.
		
		System.out.println("JDBC Test2");
		String sql = "select dname,count(*) 인원수,round(avg(sal),2) 평균" + 
					" from emp,dept" + 
					" where emp.deptno=dept.deptno" + 
					" group by dname" + 
					" order by 평균";
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection(); // 2.연결
			st = con.createStatement(); // 3.sql 관리 객체 Statement 생성
			rs = st.executeQuery(sql); // 4.sql 구문 실행

			// 4.결과값 처리
			while (rs.next()) {
				System.out.print(rs.getString("dname") + "   ");
				System.out.print(rs.getString("인원수") + "   ");
				System.out.print(rs.getString("평균") + "   ");
				System.out.println();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, st, rs);
		}
		System.out.println("**  end  **");
	}
}
