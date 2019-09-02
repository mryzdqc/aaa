package service;

import java.util.List;


import entity.Type;

public interface TypeService {
	
	public List<Type> select(String txt);
	
	public List<Type> selectType();
	
	public Type selectById(int id);
	
	public int insert(Type b);
	
	public int delete(int id);
	
	public int update(Type t);
}
