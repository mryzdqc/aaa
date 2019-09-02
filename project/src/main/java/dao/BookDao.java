package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Book;
@Repository
public interface BookDao {
//	@Select("select book.* ,type.name typename from book inner join type on book.typeid=type.id ${txt}")
//	public List<Book> select(@Param("txt") String txt);
	
	
	@Select("select count(1) from Book inner join Type on Book.typeid=Type.id ${name}")
	public int selectCount(@Param("name") String name);
	
	@Select("select Book.*,type.name typename from Book inner join Type on Book.typeid=Type.id ${name} ${limit}")
	public List<Book> select(@Param("name") String name,@Param("limit") String limit);
	
	@Select("select * from Book where id=#{id}")
	public Book selectById(int id);
	
	@Insert("insert into book(name,sex,typeid) values(#{name},#{sex},#{typeid})")
	public int insert(Book b);
	
	@Delete("delete from book where id=#{id}")
	public int delete(int id);
	
	@Update("update book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id}")
	public int update(Book b);

}
