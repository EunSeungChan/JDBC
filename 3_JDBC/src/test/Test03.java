package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class Test03 {
	public static void main(String[] args) {
		
		//select * from emp where lower(ename) like %''||'j'||'%';
		//select * from emp where lower(ename) like '%j%';
		 
		String sname =
				JOptionPane.showInputDialog("검색할 사원의 이름을 입력하세요!");
				
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null; // ? 가 있을때 사용되는
		ResultSet rs = null;
		int row = 0;

		try {
			//?가 있으면PreparedStatement 써야함  , '%'"+sname+"%' => 보안에 취약함
//String sql = "select * from emp where lower(ename) like '%'||?||'%'"; 
			String sql = "select * from emp where lower(ename) like ?";
			con = JDBCUtil.getConnection();
			
			ps = con.prepareStatement(sql); 
			//sql을 미리 컴파일 , st = con.createStatement(); 보다 성능이 더 좋음 ,ps가 st의자식
			
			// ? 세팅작업
			//ps.setString(1,sname.toLowerCase());
			  ps.setString(1,"%"+sname.toLowerCase()+"%"); //물음표가 1자리 있는데 
			
			//실행
			rs = ps.executeQuery();

			//결과값 핸들링
			
			while(rs.next()) {
				System.out.print(rs.getString("ename")+"  ");
				System.out.print(rs.getString("deptno")+"  ");
				System.out.print(rs.getString("job")+"  ");
				System.out.print(rs.getDate("hiredate")+"  ");
	//System.out.print(rs.getString("hiredate")+"  "); -> 00:00:00까지나옴 , Date함수
				System.out.println();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs); //st를 ps로
		}
		
	}

}
