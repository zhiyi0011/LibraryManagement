package librarymanagement.service;

import org.apache.ibatis.session.SqlSession;

import librarymanagement.dao.IAdminDao;
import librarymanagement.dbutil.DBUtil;
import librarymanagement.po.Admin;



public class AdminService {
	public Admin login(Admin admin) {
		SqlSession sess = DBUtil.getSession();
		IAdminDao dao = sess.getMapper(IAdminDao.class);
		Admin ad = dao.login(admin);
		sess.close();
		return ad;
	}
}
