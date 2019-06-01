package librarymanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import librarymanagement.po.BookReader;

public interface IBookReaderDao {
	@Select("select * from book")
	List<BookReader> searchAll();
}
