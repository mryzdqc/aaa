package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import entity.Book;
import service.BookService;

@Service
public class BookService_Impl implements BookService{
	@Autowired
	BookDao dao;
	
	public List<Book> select(String txt) {
		return dao.select(txt);
	}

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
	
}