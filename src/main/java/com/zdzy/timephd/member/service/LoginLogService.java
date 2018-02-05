package com.zdzy.timephd.member.service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.member.model.LoginLog;

public interface LoginLogService
{

     /**
      * 添加/更新
      */
     public boolean saveLogonLog(LoginLog loginLog);


     /**
      * 根据ID查询
      */
     public LoginLog findLogonLog(String id);

     /**
      * 根据条件查询
      */
     public PageObject queryLogonLog(QueryParamater param);

     
     /**
      * 删除
      */
     public boolean removeLogonLog(String id);

    

}