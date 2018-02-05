package com.zdzy.timephd.filter;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import com.zdzy.timephd.system.model.Admin;
import com.zdzy.timephd.util.Function;


public class BackSecurityInterceptor  extends HandlerInterceptorAdapter {
	public static Log log = LogFactory.getLog(BackSecurityInterceptor.class);
    protected String[] patterns;
    private String loginView;

    public String getLoginView() {
        return loginView;
    }

    public void setLoginView(String loginView) {
        this.loginView = loginView;
    }

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }

    public String[] getPatterns() {
        return patterns;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, Exception exception) throws Exception {
        super.afterCompletion(httpservletrequest, httpservletresponse, obj, exception);
    }

    @Override
    public void postHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, ModelAndView modelandview) throws Exception {
       
        super.postHandle(httpservletrequest, httpservletresponse, obj, modelandview);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getServletPath();
        if (matchAnyone(url)) {
           
            if (needLogin(request)) {
                return true;
            } else {
                Map map = new HashMap();
                //ModelAndView modelAndView = new ModelAndView(new RedirectView(request.getContextPath() + "/manage.jsp?login=true"), map);
                
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();  
                map.put("statusCode", "301");
                
                out.write(Function.MaptoJSON(map));  
                return false;
            }

        } else {
            return true;
        }
    }

    //认证
    private boolean needLogin(HttpServletRequest request) {
        boolean flag=false;
        Admin admin=Admin.sessionAdmin();
        if(admin!=null){
        	flag=true;
        	
        }else{
        	log.debug("登录失败。。。。");
        }
        return flag;
       
    }

    //正则匹配
    protected boolean matchAnyone(String pattern) {
        for (int i = 0; i < patterns.length; i++) {
            if (matches(pattern, i)) {
                return true;
            }
        }
        return false;
    }

    protected boolean matches(String pattern, int patternIndex) {
        try {
            boolean matched = pattern.matches(patterns[patternIndex]);
            return matched;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
