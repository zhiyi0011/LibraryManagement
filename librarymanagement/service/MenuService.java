package librarymanagement.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import librarymanagement.dao.IMenuDao;
import librarymanagement.dbutil.DBUtil;
import librarymanagement.po.Admin;
import librarymanagement.po.Menu;

public class MenuService {
	 public List<Menu> searchMenuByAdminID(Admin admin){
		SqlSession sess=DBUtil.getSession();
		IMenuDao dao=sess.getMapper(IMenuDao.class);
		List<Menu> list=dao.searchMenuByAdminID(admin);
		sess.close();
		return list;
	}
}
