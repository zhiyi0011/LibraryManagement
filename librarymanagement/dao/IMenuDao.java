package librarymanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import librarymanagement.po.Admin;
import librarymanagement.po.Menu;

public interface IMenuDao {
	@Results({
		@Result(property="mid",column="mid"),
		@Result(property="mtitle",column="mtitle"),
		@Result(property="pid",column="pid"),
		@Result(property="path",column="path"),
		@Result(property="display",column="display"),
		@Result(property="morder",column="morder"),
		@Result(property="list",column="mid",many=@Many(select="librarymanagement.dao.IMenuDao.searchSubMenu"))	
	})
	@Select("select tmenu.* from tmenu join trolermenu "
			+ "on (tmenu.mid=trolermenu.mid) join troleradmin_id "
			+ "on (trolermenu.rid=troleradmin_id.rid) "
			+ "where display=1 and aid=#{aid} ORDER BY morder")
	List<Menu> searchMenuByAdminID(Admin admin);
	
	@Select("select * from tmenu where display=1 and pid=#{id} ORDER BY morder")
	List<Menu> searchSubMenu(@Param("id")int id);
}
