package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class Test06_update {
	public static void main(String[] args) {

		String sql = "update book set title = ? ,price = ?  where bookno = ? ";
	
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

		
		try {
			
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			
			ps = con.prepareStatement(sql); 
			//sql을 미리 컴파일 , st = con.createStatement(); 보다 성능이 더 좋음
			
			// ? 세팅작업 위치index,
			ps.setString(1, "centos");
			ps.setInt(2, 2000);
			ps.setInt(3, 5);
			
			//실행
			row = ps.executeUpdate();

			//결과값 핸들링
			System.out.println("update row :  "+ row);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

}
