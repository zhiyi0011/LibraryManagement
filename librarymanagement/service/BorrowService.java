
package librarymanagement.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import librarymanagement.dao.IBorrowDao;
import librarymanagement.dbutil.DBUtil;
import librarymanagement.po.Borrow;

public class BorrowService {
	
	//查询全部信息
	public List<Borrow> searchAll(){
		SqlSession sess=DBUtil.getSession();
		IBorrowDao dao=sess.getMapper(IBorrowDao.class);
		List<Borrow> list=dao.searchAll();
		sess.close();
		return list;
	}
	//添加信息
		public boolean addBor(Borrow bor) {
			SqlSession sess = DBUtil.getSession();
			IBorrowDao dao = sess.getMapper(IBorrowDao.class);
			int temp=dao.addBor(bor);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}else {
				return false;
			}
		}
		//修改信息
		public boolean editBor(Borrow bor) {
			SqlSession sess = DBUtil.getSession();
			IBorrowDao dao = sess.getMapper(IBorrowDao.class);
			int temp=dao.editBor(bor);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}else {
				return false;
			}
		}
		//删除信息
		public boolean delBor(int Borrow_id) {
			SqlSession sess = DBUtil.getSession();
			IBorrowDao dao = sess.getMapper(IBorrowDao.class);
			int temp=dao.delBor(Borrow_id);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}else {
				return false;
			}
		}

}