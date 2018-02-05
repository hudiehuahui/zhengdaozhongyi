package com.zdzy.timephd.system.service;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.system.dao.AdminDao;
import com.zdzy.timephd.system.model.Admin;
import com.zdzy.timephd.util.Function;

@Service("systemService")
public class SystemServiceImpl implements SystemService {

	@Autowired
    @Qualifier("adminDao")
	private AdminDao adminDao;
	
	
	
	
	@Override
	public Admin loginByName(String userName) {
		// TODO Auto-generated method stub
		try{
			return adminDao.loginByName(userName);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(Function.isEmpty(admin.getID())){

				//获取ID
				admin.setID(UUID.randomUUID().toString());
				//密码加密
				admin.setPassword(Function.MD5(admin.getPassword()));
				admin.setAuthorizationcode(Function.MD5(admin.getAuthorizationcode()));
				 this.adminDao.insert(admin);
				 flag=true;
			 }else{
				//密码加密
				admin.setPassword(Function.MD5(admin.getPassword()));
				admin.setAuthorizationcode(Function.MD5(admin.getAuthorizationcode()));
				this.adminDao.update(admin);
				flag=true;
			 }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		return flag;
	}

	@Override
	public boolean deleteAadmin(String id) {
		try{
			String[] ids = id.split(",");
			for(int i=0;i<ids.length;i++){
				this.adminDao.delete(ids[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public PageObject queryAdmin(QueryParamater param) {
		try {
			return this.adminDao.query(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Admin queryAdminByID(String adminID) {
		try {
			return this.adminDao.select(adminID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Admin> queryAllAdmin() {
		List<Admin> admins= null;
		try {
			admins = this.adminDao.queryAllAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}

	@Override
	public List<Admin> queryAdminByRole(String string) {
		return this.adminDao.queryAdminByRole(string);
	}


	@Override
	public List<Admin> queryAdminByParam(Map<String, Object> param) {
		return this.adminDao.queryAdminByParam(param);
	}
}
