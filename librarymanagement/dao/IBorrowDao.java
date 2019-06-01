package librarymanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import librarymanagement.po.Borrow;

public interface IBorrowDao {
	//查询全部信息
	@Select("SELECT * FROM borrowbook")
	List<Borrow> searchAll();
	//添加
		@Insert("insert into borrowbook(Reader_id,book_id,Borrow_date,Send_date,Continue_send) "
				+ "value(#{Reader_id},#{book_id},#{Borrow_date},#{Send_date},#{Continue_send})")
		int addBor(Borrow bor);
		//修改
		@Update("update borrowbook set Reader_id=#{Reader_id},book_id=#{book_id},Borrow_date=#{Borrow_date},"
				+ "Send_date=#{Send_date},Continue_send=#{Continue_send} where Borrow_id=#{Borrow_id}")
		int editBor(Borrow bor);
		//删除
		@Delete("delete from borrowbook where Borrow_id=#{Borrow_id}")
		int delBor(@Param("Borrow_id")int Borrow_id);
}