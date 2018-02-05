package com.zdzy.timephd.member.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.member.dao.LoginLogDao;
import com.zdzy.timephd.member.model.LoginLog;
import com.zdzy.timephd.util.Function;


@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService
{


	 @Autowired
 	 private LoginLogDao loginLogDao;

     
     /**
      * 添加/更新
      */
     @Override
     public boolean saveLogonLog(LoginLog loginLog){
     
        boolean flag = false;
		try {
			if (Function.isEmpty(loginLog.getId())) {
				loginLog.setId(UUID.randomUUID().toString());
				loginLogDao.insert(loginLog);
				flag = true;
			} else {
				loginLogDao.update(loginLog);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
     }

     /**
      * 根据ID查询
      */
     @Override
     public LoginLog findLogonLog(String id){
		LoginLog logonLog = null;
		try {
			logonLog = this.loginLogDao.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logonLog;

     }

     /**
      * 根据条件查询
      */
     @Override
     public PageObject queryLogonLog(QueryParamater param){
		
		PageObject po = null;
		try {
			po = this.loginLogDao.query(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po; 
		    	
     }

     
     /**
      * 删除
      */
     @Override
     public boolean removeLogonLog(String id){
     	boolean flag = false;
		try {
			this.loginLogDao.delete(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
     }

    

}