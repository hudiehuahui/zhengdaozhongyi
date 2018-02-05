package com.zdzy.timephd.system.back;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.system.model.Module;
import com.zdzy.timephd.system.service.ModuleService;
import com.zdzy.timephd.util.Function;

@Controller
@RequestMapping("/back/module")
public class ModuleController {


	@Autowired
	private ModuleService moduleService;

	
	@RequestMapping("/moduleList.do")
	public String queryAllAdmin(HttpServletResponse response, HttpServletRequest request
			,ModelMap modelMap) throws Exception {
		QueryParamater param = new QueryParamater();
		//分页
		if(!Function.isEmpty(request.getParameter("pageCurrent"))){
			param.setCurrentPage(Function.parseInt(request.getParameter("pageCurrent"), 0)-1);//当前页
			param.setNeverypage(Function.parseInt(request.getParameter("pageSize"), 0));//每页个数
		}
		
		PageObject po = moduleService.queryModule(param);
		modelMap.put("po", po);
		return "back/module/moduleList";
	}
	
	
	
	
	@RequestMapping("/addModuleForm.do")
	public String addModuleForm(HttpServletResponse response, HttpServletRequest request
			,ModelMap modelMap) throws Exception {
		return "back/module/moduleForm";
	}
	
	
	@RequestMapping("/saveModule.do")
	@ResponseBody
	public String saveModule(HttpServletResponse response, HttpServletRequest request
			,ModelMap modelMap) throws Exception {
		String name= request.getParameter("name");
		String number= request.getParameter("number");
		String descb= request.getParameter("descb");
		Module module = new Module();
		module.setId(UUID.randomUUID().toString());
		module.setName(name);
		module.setNumber(Integer.valueOf(number));
		module.setDescb(descb);
		module.setCreateDate(new Date());
		module.setUpdateDate(new Date());
		this.moduleService.saveModule(module);
		return "success";
	}
	
	
	
	@RequestMapping("/removeModule.do")
	@ResponseBody
	public String removeModule(HttpServletResponse response, HttpServletRequest request
			,ModelMap modelMap,String id) throws Exception {
		if(!Function.isEmpty(id)){
			this.moduleService.deleteModule(id);
		}
		return "success";
	}

	

}
