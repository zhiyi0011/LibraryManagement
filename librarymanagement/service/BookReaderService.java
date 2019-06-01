package librarymanagement.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import librarymanagement.dao.IBookReaderDao;
import librarymanagement.dbutil.DBUtil;
import librarymanagement.po.BookReader;

public class BookReaderService {
	public List<BookReader> searchAll() {
		SqlSession sess = DBUtil.getSession();
		IBookReaderDao dao = sess.getMapper(IBookReaderDao.class);
		List<BookReader> list = dao.searchAll();
		sess.close();
		return list;
	}
}
