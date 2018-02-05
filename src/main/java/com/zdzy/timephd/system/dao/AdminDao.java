package com.zdzy.timephd.system.dao;

import java.util.List;
import java.util.Map;

import com.zdzy.framework.dao.BaseDao;
import com.zdzy.timephd.system.model.Admin;

public interface AdminDao extends BaseDao<Admin, String>
{
	/**
	 * 系统管理员登录
	 * @param userName
	 * @return
	 */
	public Admin loginByName(String userName);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Admin> queryAllAdmin() ;

	/**
	 * 根据角色查询
	 * @param string
	 * @return
	 */
	public List<Admin> queryAdminByRole(String role);
	/**
	 * 按条件查询
	 * @param param
	 * @return
	 */
	public List<Admin> queryAdminByParam(Map<String, Object> param);
	
}
