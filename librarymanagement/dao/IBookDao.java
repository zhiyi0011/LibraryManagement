package librarymanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import librarymanagement.po.Book;




public interface IBookDao {
	@Select("select * from book")
	List<Book> searchAll();
	//添加
	@Insert("insert into book(bname,bauthor,borrow,btype,Inventory)"
			+ "values(#{bname},#{bauthor},#{borrow},#{btype},#{Inventory})")
	int addboo(Book boo);
	//修改
	@Update("update book set bname=#{bname},bauthor=#{bauthor},borrow=#{borrow},"
			+ "btype=#{btype},Inventory=#{Inventory} where book_id=#{book_id}")
	int editboo(Book boo);
	//删除
	@Delete("delete from book where book_id=#{book_id}")
	int delboo(@Param("book_id")int book_id);
}
