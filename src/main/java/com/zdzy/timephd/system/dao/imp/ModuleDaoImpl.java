package com.zdzy.timephd.system.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.system.dao.ModuleDao;
import com.zdzy.timephd.system.model.Module;
@Repository("moduleDao")
public class ModuleDaoImpl extends IbatisDaoImp<Module, String> implements ModuleDao
{

	@Override
	public List<Module> searchAllModule() {
		return this.getSqlSession().selectList(this.getSqlmapNamespace()+".queryAllModule");
	}

}
