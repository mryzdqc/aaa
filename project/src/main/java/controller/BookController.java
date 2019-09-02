package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Book;
import entity.Type;
import service.BookService;
import service.TypeService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@Autowired
	TypeService tservice;
	
	@GetMapping("index")
	public String  test(String txt,ModelMap m) {
		return "Book/index2";
	}
	
	@GetMapping("index2")
	public @ResponseBody ReturnInfo index(String txt ,Integer page,Integer limit,ModelMap m) {
		if(txt==null||txt.length()==0) txt="";
		return service.select(txt, page, limit);
	}
	
	@PostMapping("insert")//post新增请求
	public @ResponseBody String insert(Book b,ModelMap m) {
		service.insert(b);
		return "{\"status\":1}";
	}
	@GetMapping("add")
	public String add(ModelMap m) {
		m.put("sexs", Book.sexs);
		m.put("typelist", tservice.select(""));
		return "Book/edit";
	}
	@DeleteMapping("delete")//delete删除请求
	public @ResponseBody String delete(int id,ModelMap m) {
		service.delete(id);
		return "{\"status\":1}";
	}

	
	@GetMapping("edit0")
	public String edit0(ModelMap m) {//中转请求参数
		//m.put("id", id);
//		m.put("typelist", tservice.select(""));
//		m.put("info",service.selectById(id));
		return "Book/edit";
	}
	
	
	@GetMapping("edit")
	public @ResponseBody Book edit(int id,ModelMap m) {
//		m.put("sexs", Book.sexs);
//		m.put("typelist", tservice.select(""));
//		m.put("info",service.selectById(id));
		return service.selectById(id);
	}
	@PutMapping("update")//put修改请求
	public @ResponseBody String update(Book b,ModelMap m) {
		service.update(b);
		return "{\"status\":1}";
	}
	
	@GetMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Book.sexs;
	}
	
	@GetMapping("getTypes")
	public @ResponseBody List<Type> getTypes() {
		return tservice.selectType();
	}
	
}
