package com.zdzy.timephd.system.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.system.dao.AdminDao;
import com.zdzy.timephd.system.model.Admin;
@Repository("adminDao")
public class AdminDaoImpl extends IbatisDaoImp<Admin, String> implements AdminDao
{

	@Override
	public Admin loginByName(String userName) {
		// TODO Auto-generated method stub
	 return (Admin)this.getSqlSession().selectOne(this.getSqlmapNamespace() + ".loginByName", userName);
	}


	@Override
	public List<Admin> queryAllAdmin() {
		return this.getSqlSession().selectList(this.getSqlmapNamespace() + ".queryAllAdmins");
	}

	@Override
	public List<Admin> queryAdminByRole(String role) {
		return this.getSqlSession().selectList(this.getSqlmapNamespace() + ".queryAdminByRole",role);
	}


	@Override
	public List<Admin> queryAdminByParam(Map<String, Object> map) {
		return this.getSqlSession().selectList(this.getSqlmapNamespace() + ".queryAdminByParam",map);
	}
	
}
