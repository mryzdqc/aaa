package service;

import java.util.List;


import entity.Book;
import utils.ReturnInfo;

public interface BookService {
	
	public ReturnInfo  select(String txt,Integer page,Integer limit);
	
	public Book selectById(int id);
	
	public int insert(Book b);
	
	public int delete(int id);
	
	public int update(Book b);
}
