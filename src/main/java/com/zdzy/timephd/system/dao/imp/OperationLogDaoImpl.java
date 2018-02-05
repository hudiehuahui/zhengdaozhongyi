package com.zdzy.timephd.system.dao.imp;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.system.dao.OperationLogDao;
import com.zdzy.timephd.system.model.OperationLog;
@Repository("operationLogDao")
public class OperationLogDaoImpl extends IbatisDaoImp<OperationLog, String> implements OperationLogDao
{


}
