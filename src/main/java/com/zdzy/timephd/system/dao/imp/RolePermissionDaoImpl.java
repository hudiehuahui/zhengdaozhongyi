package com.zdzy.timephd.system.dao.imp;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.system.dao.RolePermissionDao;
import com.zdzy.timephd.system.model.RolePermission;
@Repository("rolePermissionDao")
public class RolePermissionDaoImpl extends IbatisDaoImp<RolePermission, String> implements RolePermissionDao
{

}
