package service;

import java.util.List;

import vo.BookVO;

					//명명규칙 - service 항상 붙어야함 ,interface 
public interface BookService {
	
	List<BookVO> bookList();
	//int addBook(String t,String a,int p, String d ) throws Exception;
	int addBook(BookVO vo) throws Exception; //vo객체를파라미터전송할때도 사용가능함

	
}
