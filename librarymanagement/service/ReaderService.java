package librarymanagement.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import librarymanagement.dao.IReaderDao;
import librarymanagement.dbutil.DBUtil;
import librarymanagement.po.Reader;


public class ReaderService {
	
	//查询全部信息
	public List<Reader> searchAll(){
		SqlSession sess=DBUtil.getSession();
		IReaderDao dao=sess.getMapper(IReaderDao.class);
		List<Reader> list=dao.searchAll();
		sess.close();
		return list;
		
	};
	//添加信息
		public boolean addRea(Reader rea) {
			SqlSession sess=DBUtil.getSession();
			IReaderDao dao=sess.getMapper(IReaderDao.class);
			int temp=dao.addRea(rea);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}else {
				return false;
			}
			
		}

		//修改
		public boolean editRea(Reader rea) {
			SqlSession sess=DBUtil.getSession();
			IReaderDao dao=sess.getMapper(IReaderDao.class);
			int temp=dao.editRea(rea);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}else {
				return false;
			}
			
		}
		
		//删除
		public boolean delRea(int Reader_id) {
			SqlSession sess=DBUtil.getSession();
			IReaderDao dao=sess.getMapper(IReaderDao.class);
			int temp=dao.delRea(Reader_id);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}else {
				return false;
			}
			
		}		

}