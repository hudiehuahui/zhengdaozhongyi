package com.zdzy.timephd.system.dao.imp;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.system.dao.RoleDao;
import com.zdzy.timephd.system.model.Role;
@Repository("roleDao")
public class RoleDaoImpl extends IbatisDaoImp<Role, String> implements RoleDao
{

}
