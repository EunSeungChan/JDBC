package App;

import java.util.List;

import dao.BookDAO;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

public class BookApp {
	public static void main(String[] args) {
		
		//dao어떻게 써야댈지
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao); // 다양한 방법으로 교체가능
		
		//
		BookVO user = new BookVO("ajax","kim",7700);
		try {
			service.addBook(user);
			
		} catch (Exception e) {
			System.out.println("등록데이터 확인필요");
		}
		
		if(service != null) {
	//client 
		List<BookVO> list = service.bookList();
		list.forEach(i->System.out.println(i));
		}
	}

}
