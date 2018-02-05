package com.zdzy.timephd.system.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.system.dao.ModuleDao;
import com.zdzy.timephd.system.model.Module;
import com.zdzy.timephd.util.Function;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public PageObject queryModule(QueryParamater param) {
		try {
			PageObject po = this.moduleDao.query(param);
			return po;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveModule(Module module) {
		try {
			if(!Function.isEmpty(module.getId())){
				this.moduleDao.insert(module);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteModule(String id) {
		try {
			this.moduleDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Module findModuleById(String id) {
		Module module = this.moduleDao.select(id);
		return module;
	}

	@Override
	public List<Module> searchAllModule() {
		List<Module> list = this.moduleDao.searchAllModule();
		return list;
	}

}
