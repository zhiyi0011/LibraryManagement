package librarymanagement.dao;

import org.apache.ibatis.annotations.Select;

import librarymanagement.po.Admin;


public interface IAdminDao {
	@Select("select * from admin where Aname=#{Aname} and Password=#{Password}")
	Admin login(Admin admin);
}
