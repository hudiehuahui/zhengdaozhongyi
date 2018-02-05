package com.zdzy.timephd.system.service;

import java.util.List;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.system.model.Module;


public interface ModuleService {

	PageObject queryModule(QueryParamater param);
	
    void saveModule(Module module);
    
    void deleteModule(String id);
    
    Module findModuleById(String id);
    
    List<Module> searchAllModule();
}
