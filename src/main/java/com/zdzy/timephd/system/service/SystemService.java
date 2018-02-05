package com.zdzy.timephd.system.service;

import java.util.List;
import java.util.Map;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.system.model.Admin;


public interface SystemService {

	/**
	 * 系统管理员登录
	 * @param userName
	 * @return
	 */
	public Admin loginByName(String userName);
	
	
	/**
	 * 添加管理员或更新管理员
	 * @param admin
	 * @return
	 */
	public boolean saveAdmin(Admin admin);
	
	/**
	 * 根据删除管理员
	 * @param id
	 * @return
	 */
	public boolean deleteAadmin(String id);
	/**
	 * 查询所有用户
	 * @param param
	 * @return
	 */
	public PageObject queryAdmin(QueryParamater param);

    /**
     * 按条件查询
     * @param param
     * @return
     */
	public List<Admin> queryAdminByParam(Map<String, Object> param);
	/**
	 * 根据ID查询用户
	 * @param AdminID
	 * @return
	 */
	public Admin queryAdminByID(String adminID);

	/**
	 * 根据查询所有用户
	 * @return
	 */
	public List<Admin> queryAllAdmin();

	/**
	 * 根据角色查询
	 * @param string
	 * @return
	 * @author bxt-chen
	 */
	public List<Admin> queryAdminByRole(String string);
	
    
}
