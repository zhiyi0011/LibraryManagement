package librarymanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import librarymanagement.po.Bookdemage;

public interface BookdemageDao {
	//查询全部信息
	@Select("SELECT * FROM bookdemage")
	List<Bookdemage> searchAll();
//		@Update("update bookdemage set dname=#{dname},writer=#{writer},dtype=#{dtype},"
//			+ "dInventory=#{dInventory},damage=#{damage} where demage_id=#{demage_id}")
	@Update("update bookdemage set damage=#{damage} where demage_id=#{demage_id}")
		int editDem(Bookdemage dem);	
}
