package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class Test08_select_list {
	public static void main(String[] args) {

		String sql = "select * from book";
	
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

	//List Book 배열생성
		List<BookVO> books = new ArrayList<BookVO>();
		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql); 
			//sql을 미리 컴파일 , st = con.createStatement(); 보다 성능이 더 좋음
			
			// ? 세팅작업
			
			//실행
			rs = ps.executeQuery();
			
			//결과값 핸들링
			while(rs.next()) {
			//Book객체 생성
				BookVO book = new BookVO();
				book.setPrice(rs.getInt("price"));
				book.setAuthor(rs.getString("author"));
				book.setBookno(rs.getInt("bookno"));
				book.setTitle(rs.getString("title"));
				book.setPubdate(rs.getDate("pubdate").toString()); //date로 꺼낸담에 string로 변환
			//System.out.println(book);
			// book의 주소 모은거
				
				books.add(book); 
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
	//close한다음에도 book객체 사용가능함
		System.out.println("Book List");
		for(BookVO d : books) {
			System.out.println(d);
		}
		System.out.println("------------------------------------------------");
		//stream forEach , i(book) -> d , 람다식
		books.forEach(book->System.out.println(book));
		
		
	}

}
