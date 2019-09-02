package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import entity.Type;
@Repository
public interface TypeDao {
//	@Select("select Type.* ,type.name typename from Type inner join type on Type.typeid=type.id ${txt}")
//	public List<Type> select(@Param("txt") String txt);
	
	@Select("select * from type ")
	public List<Type> select(String txt);
	
	public Type selectById(int id);
	
	@Insert("insert into Type(name,sex,typeid) values(#{name},#{sex},#{typeid})")
	public int insert(Type b);
	
	@Delete("delete from Type where id=#{id}")
	public int delete(int id);
	
	@Select("select * from type ")
	public List<Type> selectType();

}
