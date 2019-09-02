package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import entity.Type;
import service.TypeService;

@Service
public class TypeService_Impl implements TypeService{
	@Autowired
	TypeDao dao;
	
	public List<Type> select(String txt) {
		return dao.select(txt);
	}

	public Type selectById(int id) {
		return dao.selectById(id);
	}
	
	public int insert(Type b) {
		return dao.insert(b);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}

	public List<Type> selectType() {
		return dao.selectType();
	}

	public int update(Type t) {
		
		return dao.update(t);
	}
}
