package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class Test05_delete {
	public static void main(String[] args) {

		String sql = "delete from book where bookno = ? ";
	
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql); 
			//sql을 미리 컴파일 , st = con.createStatement(); 보다 성능이 더 좋음
			
			// ? 세팅작업  ? 없으면 세팅X
			ps.setInt(1, 1);
			
			//실행 - 복구불가 오토커밋 , 롤백 불가능
			row = ps.executeUpdate();
			
			//결과값 핸들링
			System.out.println("delete row :  "+ row);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

}
