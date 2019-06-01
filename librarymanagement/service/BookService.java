package librarymanagement.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import librarymanagement.dao.IBookDao;
import librarymanagement.dbutil.DBUtil;
import librarymanagement.po.Book;





public class BookService {
	public List<Book> searchAll(){
		SqlSession sess=DBUtil.getSession();
		IBookDao dao=sess.getMapper(IBookDao.class);
		List<Book> list=dao.searchAll();
		sess.close();
		return list;
	}
	//添加信息
	public boolean addboo(Book boo) {
		SqlSession sess=DBUtil.getSession();
		IBookDao dao=sess.getMapper(IBookDao.class);
		int temp=dao.addboo(boo);
		sess.commit();
		sess.close();
		if(temp>0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	//修改
		public boolean editboo(Book boo) {
			SqlSession sess=DBUtil.getSession();
			IBookDao dao=sess.getMapper(IBookDao.class);
			int temp=dao.editboo(boo);
			sess.commit();
			sess.close();
			if(temp>0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		//删除
			public boolean delboo(int id) {
				SqlSession sess=DBUtil.getSession();
				IBookDao dao=sess.getMapper(IBookDao.class);
				int temp=dao.delboo(id);
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
