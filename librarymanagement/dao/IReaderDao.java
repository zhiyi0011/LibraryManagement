
package librarymanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import librarymanagement.po.Reader;


public interface IReaderDao {
	// 查询全部信息
	@Select("SELECT reader.Reader_id,reader.Rname,reader.Sex,reader.Depart FROM reader")

	List<Reader> searchAll();

	// 添加
	@Insert("insert into reader(Reader_id,Rname,Sex,Depart) "
			+ "values(#{Reader_id},#{Rname},#{Sex},#{Depart})")
	int addRea(Reader rea);

	// 修改
	@Update("update reader set Rname=#{Rname},Sex=#{Sex},Depart=#{Depart} where Reader_id=#{Reader_id}")
	int editRea(Reader rea);

	// 删除
	@Delete("delete from reader where Reader_id=#{Reader_id}")
	int delRea(@Param("Reader_id") int Reader_id);

}