package com.zdzy.timephd.system.dao;

import java.util.List;
import java.util.Map;

import com.zdzy.framework.dao.BaseDao;
import com.zdzy.timephd.system.model.Admin;
import com.zdzy.timephd.system.model.Module;

public interface ModuleDao extends BaseDao<Module, String>
{
	
	public List<Module> searchAllModule();
	
}
