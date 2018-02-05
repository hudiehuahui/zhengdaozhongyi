package com.zdzy.timephd.system.back;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zdzy.timephd.statuscode.Constants;
import com.zdzy.timephd.system.model.Admin;
import com.zdzy.timephd.system.service.OperationLogService;
import com.zdzy.timephd.system.service.SystemService;
import com.zdzy.timephd.util.Function;

@Controller
@RequestMapping("/system")
public class AdminLoginController {
	Log log = LogFactory.getLog(AdminLoginController.class);
	@Autowired
	private SystemService systemService;
	@Autowired
	private OperationLogService operationLogService;
	/**
	 * 管理员登录
	 * 
	 * @param request
	 * @param response
	 * @param j_username
	 * @param verifycode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login.do",method = {RequestMethod.POST})
	 	public String login(HttpServletRequest request,HttpServletResponse response,
	 			String j_username,String keyid,String keyname,String keypassword,String verifycode)throws Exception{
	 		
	 		HttpSession session = request.getSession();
	 		//用户名
	        String loginName = j_username;
	        //密码
	        String loginPsw = keypassword;
	        //用戶輸入的验证码
	        String loginCode = verifycode;
	        //用户名，密码或者验证码为空
	        if (Function.isEmpty(loginName) || Function.isEmpty(loginPsw)) {
	            session.setAttribute("flag", "passwordError");
	            return "redirect:/manage.jsp";
	        }
	     // 加密后的用户输入密码
	     	loginPsw = Function.MD5(loginPsw);
	     	Admin admin = null;
	     	
	        session.removeAttribute(Constants.SESSION_VERIFY_CODE);
	        
	        	 //根据用户名查询当前用户
        	admin = systemService.loginByName(loginName);
	       
	        if(admin==null){
	        	 //用户不存在
	        	 session.setAttribute("flag", "usererror");
	        	 return "redirect:/manage.jsp";
	        }
	        String loginPassword = admin.getPassword(); // 加密后的数据库中的正确密码
			if (!loginPsw.equals(loginPassword)) {
				// 密码错误
				log.debug("密码错误。。。。");
				return "redirect:/manage.jsp";
			}
	        /** 证书验证 不校验密码 **/
	         //保存当前管理员session
	         session.setAttribute(Constants.SESSION_ADMIN, admin);
//	         long start = System.currentTimeMillis();
	        if ("1".equals(admin.getRoleId())) {
	 			log.debug("管理员登录");
	 			return "redirect:index.do";
	        }else{
	        	log.error("未知类型");
	        	return "redirect:/manage.jsp";
	        }
	 	}

	/**
	 * 管理员注销
	 * 
	 * @param request
	 * @param httpServletResponse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout.do", method = { RequestMethod.GET })
	public String logout(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.SESSION_ADMIN);
		session.invalidate();
		return "redirect:/manage.jsp";
	}

	@RequestMapping(value = "/tab.do", method = { RequestMethod.GET })
	public String sysTab(HttpServletRequest request, HttpServletResponse httpServletResponse, Model model) throws Exception {
		return "back/system/tab";
	}

	@RequestMapping(value = "/default.do", method = { RequestMethod.GET })
	public String sysDefault(HttpServletRequest request, HttpServletResponse httpServletResponse,ModelMap modelMap) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.add(Calendar.MONTH,-1);
		cal.set(Calendar.DAY_OF_MONTH,15);
		cal2.add(Calendar.MONTH,1);
		cal2.set(Calendar.DAY_OF_MONTH,15);
		String beginDate =  sdf.format(cal.getTime());
		String endDate = sdf.format(cal2.getTime());

		log.debug(beginDate);
		log.debug(endDate);


		return "back/system/default";
	}


	/**
	 * 查询出证日期
	 * 根据出证日期获取当日待出证的数量
	 * @author wangna
	 */
	@RequestMapping(value = "/index.do", method = { RequestMethod.GET })
	public String index(HttpServletRequest request, HttpServletResponse httpServletResponse, ModelMap model) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute(Constants.SESSION_ADMIN);
		model.put("admin",admin);
		return "back/system/index";
	}

	@RequestMapping(value = "/auditIndex.do", method = { RequestMethod.GET })
	public String auditIndex(HttpServletRequest request, HttpServletResponse httpServletResponse, ModelMap model) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute(Constants.SESSION_ADMIN);
		model.put("admin",admin);
		return "back/system/auditIndex";
	}
	@RequestMapping(value = "/proxyIndex.do", method = { RequestMethod.GET })
	public String proxyIndex(HttpServletRequest request, HttpServletResponse httpServletResponse, Model model) throws Exception {
		return "back/system/proxyIndex";
	}
	@RequestMapping(value = "/makeCertIndex.do", method = { RequestMethod.GET })
	public String makeCertIndex(HttpServletRequest request, HttpServletResponse httpServletResponse, Model model) throws Exception {
		return "back/system/makeCertIndex";
	}
	@RequestMapping(value = "/financeIndex.do", method = { RequestMethod.GET })
	public String financeIndex(HttpServletRequest request, HttpServletResponse httpServletResponse, Model model) throws Exception {
		return "back/system/financeIndex";
	}
	@RequestMapping(value = "/reviewIndex.do", method = { RequestMethod.GET })
	public String reviewIndex(HttpServletRequest request, HttpServletResponse httpServletResponse, Model model) throws Exception {
		return "back/system/reviewIndex";
	}

}
