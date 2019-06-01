package librarymanagement.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import librarymanagement.dao.BookdemageDao;
import librarymanagement.dbutil.DBUtil;
import librarymanagement.po.Bookdemage;

public class BookdemageService {
	//查询全部信息
		public List<Bookdemage> searchAll(){
			SqlSession sess=DBUtil.getSession();
			BookdemageDao dao=sess.getMapper(BookdemageDao.class);
			List<Bookdemage> list=dao.searchAll();
			sess.close();
			return list;
		}
		//修改
		public boolean editdem(Bookdemage dem) {
			SqlSession sess=DBUtil.getSession();
			BookdemageDao dao=sess.getMapper(BookdemageDao.class);
			int temp=dao.editDem(dem);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}
			else {
				return false;
			}
		}
}
