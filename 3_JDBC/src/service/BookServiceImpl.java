package service;

import java.util.List;

import dao.BookDAO;
import vo.BookVO;

//service에서는 DB연동하는 코드 직접 연결하면 안됨 -> DAO 별도로 만들어야함
public class BookServiceImpl implements BookService{
//service layer 
	private BookDAO dao = null ; //맴버변수 => private 처리, dao로만 동작을 해야함
	
	//생성자,private -> setter,getter
	
	public BookServiceImpl() {
		super();
	}
	
	public BookServiceImpl(BookDAO dao) {
		super();
		this.dao = dao;
	}
	
	public BookDAO getDao() {
		return dao;
	}

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<BookVO> bookList() {
		return dao.booklist();
	}

	@Override
	public int addBook(BookVO vo) throws Exception {
		return dao.addBook(vo);
	}
	
}
