package com.zdzy.timephd.member.back;

/**
 * 管理员操作
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.member.model.Account;
import com.zdzy.timephd.member.service.AccountService;
import com.zdzy.timephd.system.model.Module;
import com.zdzy.timephd.system.service.ModuleService;
import com.zdzy.timephd.util.Function;

@Controller
@RequestMapping("/back/member")
public class AccountController {

	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@Autowired
	private ModuleService moduleService;

	/**
	 * 账户查询(包含过滤条件查询)
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/accountList.do")
	public String accountList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {

		QueryParamater param = new QueryParamater();
		
		String orderField = request.getParameter("orderField");
		String orderDirection = request.getParameter("orderDirection");
		param.put("orderField", orderField);
		param.put("orderDirection", orderDirection);
		
		//分页
		if(!Function.isEmpty(request.getParameter("pageCurrent"))){
			param.setCurrentPage(Function.parseInt(request.getParameter("pageCurrent"), 0)-1);//当前页
			param.setNeverypage(Function.parseInt(request.getParameter("pageSize"), 0));//每页个数
		}

		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String accountState = request.getParameter("accountState");
		String nation = request.getParameter("nation");
		String sex = request.getParameter("sex");
		String phoneNumber = request.getParameter("phoneNumber");
		
		//民族查询
		if (!Function.isEmpty(nation)) {
			param.put("nation", nation.trim());
			modelMap.put("nation", nation.trim());
		}
		//性别查询
		if (!Function.isEmpty(sex)) {
			param.put("sex", sex);
			modelMap.put("sex", sex);
		}
		//电话号码查询
		if (!Function.isEmpty(phoneNumber)) {
			param.put("phoneNumber", phoneNumber.trim());
			modelMap.put("phoneNumber", phoneNumber.trim());
		}
		
		/** 添加用户名查询 **/
		if (!Function.isEmpty(userName)) {
			param.put("userName", userName.trim());
			modelMap.put("userName", userName.trim());
		}
		//邮箱查询
		if(!Function.isEmpty(email) && !"".equals(email)){
			param.put("email", email);
			modelMap.put("email", email);
		}
		//账号状态查询
		if(!Function.isEmpty(accountState) && !"".equals(accountState)){
			param.put("accountState", accountState);
			modelMap.put("accountState", accountState);
		}
		PageObject po = accountService.queryAccount(param);
		modelMap.put("po", po);
		return "/back/member/accountList";

	}

	/**
	 * 账户表单操作
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/accountForm.do")
	public String accountForm(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, String id) throws Exception {
		Account account = null;
		if (!Function.isEmpty(id)) {
			account = accountService.findAccount(id);
		} else {
			account = new Account();
			account.setId(null);
		}
		if(account != null){
			modelMap.put("accountForm", account);
		}
		
		return "/back/member/accountForm";
	}
	
	/**
	 * 账户修改页面
	 * @date 2016-8-20下午5:07:00
	 * @author gaolu
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/accountUpdateForm.do")
	public String accountUpdateForm(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, String id) throws Exception {
		Account accountForm = null;
		if (!Function.isEmpty(id)) {
			accountForm = accountService.findAccount(id);
			modelMap.put("accountForm", accountForm);
		}
		return "/back/member/accountUpdateForm";
	}
	
	
	/**
	 * 删除账户
	 * @date 2016-8-20下午4:45:59
	 * @author gaolu
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAccount.do")
	@ResponseBody
	public String deleteAccount(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, String id) throws Exception {
		if (!Function.isEmpty(id)) {
			boolean flag = this.accountService.removeAccount(id);
			if(flag){
				return "success";
			}else{
				return "fail";
			}
		}else {
			
			return "null";
		}
		
	}
	
	
	/**
	 * 修改账户后保存提交
	 * 
	 * @param account
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateAccount.do", method = { RequestMethod.POST })
	@ResponseBody
	public String updateAdmin(HttpServletRequest request, ModelMap modelMap,String id,String userName,String password,String email,String phoneNumber,
			String sex,String nation,String accountState,String accountType) throws Exception {
		/** 执行数据保存 **/
		Account account = this.accountService.findAccount(id);
		if(account!= null){
			if (!Function.isEmpty(password)) {
				account.setPassword(password);
			}
			account.setEmail(email);
			account.setAccountState(Integer.valueOf(accountState));
			account.setAccountType(Integer.valueOf(accountType));
			account.setNation(nation);
			account.setPhoneNumber(phoneNumber);
			account.setSex(Integer.valueOf(sex));
			account.setUserName(userName);
			this.accountService.saveAccount(account);
			return "success";
		}else {
			return "false";
		}
	}
	
	
	@RequestMapping("/moduleOfAccountForm.do")
	public String moduleOfAccountForm(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, String id) throws Exception {
		QueryParamater param = new QueryParamater();
		param.setNeverypage(150);
		//分页
		if(!Function.isEmpty(request.getParameter("pageCurrent"))){
			param.setCurrentPage(Function.parseInt(request.getParameter("pageCurrent"), 0)-1);//当前页
			param.setNeverypage(Function.parseInt(request.getParameter("pageSize"), 0));//每页个数
		}
		Account accountForm = accountService.findAccount(id);
		
		PageObject po = moduleService.queryModule(param);
		
		List<Module> mlist = this.moduleService.searchAllModule();
		StringBuffer sb = new StringBuffer();
		String all ;
		if(mlist != null){
			for(Module module : mlist){
				sb.append(module.getName());
			}
			all = sb.toString();
			modelMap.put("all", all);
		}else{
			modelMap.put("all", "");
		}
		
		
		String ss = accountForm.getShortId();
		modelMap.put("ss",ss);
		modelMap.put("po", po);
		modelMap.put("accountForm", accountForm);
		return "/back/module/AccountModuleForm";
	}
	
	
	@RequestMapping("/giveModuleToAccount.do")
	@ResponseBody
	@Transactional
	public String giveModuleToAccount(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String ids, String accountId) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (!Function.isEmpty(ids)) {
			if (ids.indexOf(",") != -1) {
				String idss[] = ids.split(",");
				for (String id : idss) {
					Module module = this.moduleService.findModuleById(id);
					sb.append(module.getName());
				}
			}else {
				Module module = this.moduleService.findModuleById(ids);
				sb.append(module.getName());
			}
		} else{
			sb.append("");
		}
		String ss = sb.toString();
		Account account = this.accountService.findAccount(accountId);
		account.setShortId(ss);	
		this.accountService.saveAccount(account);
		return "success";
	}
}
