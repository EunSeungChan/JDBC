package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02 {
	public static void main(String[] args) {

		//emp table에서 부서별 평균 급여(소수점두자리)와 인원수를 구해서 출력하세요.
		
		System.out.println("JDBC Test2");
		String sql = "select dname,count(*) 인원수,round(avg(sal),2) 평균" + 
					" from emp,dept" + 
					" where emp.deptno=dept.deptno" + 
					" group by dname" + 
					" order by 평균";
		
		
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "TIGER";
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pw);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.print(rs.getString("dname") + "   ");
				System.out.print(rs.getString("인원수") + "   ");
				System.out.print(rs.getString("평균") + "   ");
				System.out.println();
				
			}
				
		}catch(ClassNotFoundException e) {
				System.out.println("jdbc driver 확인 요.");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}finally {
			//자원반납
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("** end **");
	}
}
