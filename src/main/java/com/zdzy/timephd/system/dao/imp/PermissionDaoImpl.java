package com.zdzy.timephd.system.dao.imp;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.system.dao.PermissionDao;
import com.zdzy.timephd.system.model.Permission;
@Repository("permissionDao")
public class PermissionDaoImpl extends IbatisDaoImp<Permission, String> implements PermissionDao
{

}
