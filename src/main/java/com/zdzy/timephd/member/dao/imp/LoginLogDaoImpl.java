package com.zdzy.timephd.member.dao.imp;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.member.dao.LoginLogDao;
import com.zdzy.timephd.member.model.LoginLog;
@Repository("loginLogDao")
public class LoginLogDaoImpl extends IbatisDaoImp<LoginLog, String> implements LoginLogDao
{

}
