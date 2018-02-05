package com.zdzy.timephd.tools.dao.imp;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.tools.dao.ServiceFailDao;
import com.zdzy.timephd.tools.model.ServiceFail;

@Repository("serviceFailDao")
public class ServiceFailDaoImpl extends IbatisDaoImp<ServiceFail, String> implements ServiceFailDao {

}
