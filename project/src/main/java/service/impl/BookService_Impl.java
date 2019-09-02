package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import entity.Book;
import service.BookService;
import utils.ReturnInfo;

@Service
public class BookService_Impl implements BookService{
	@Autowired
	BookDao dao;
	
	public Book selectById(int id) {
		return dao.selectById(id);
	}
	
	public int insert(Book b) {
		return dao.insert(b);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}

	public int update(Book b) {
		return dao.update(b); 
	}

	public ReturnInfo select(String txt, Integer page, Integer limit) {
		if(txt==null||txt.length()==0) txt="";
		else txt="where book.name like '%"+txt+"%'";
		ReturnInfo info = new ReturnInfo();
		String limitstr="";
		if(page!=null) {
			limitstr="limit "+((page-1)*limit)+","+limit;
			info.setCount(dao.selectCount(txt));
		}
		info.setList(dao.select(txt,limitstr));
		return info;
	}
	
}
